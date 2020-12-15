package subway.dashboard;

import static subway.dashboard.DashboardWords.*;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import subway.SubwayExceptions.ExceptionStationNameNoExists;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;

public class StretchDashboard {

    TreeMap<String, String> options;
    InputView inputView;
    boolean power;

    public StretchDashboard(InputView inputView) {
        this.inputView = inputView;
        power = true;
        options = new TreeMap<>();
        options.put(OPTION_NUM_1, DASHBOARD_STRETCH_OPTION_1);
        options.put(OPTION_NUM_2, DASHBOARD_STRETCH_OPTION_2);
        options.put(OPTION_BACK, DASHBOARD_OPTION_B);
        startStretchDashboard(inputView);

    }

    public void showStretchDashboardName() {
        System.out.println(DASHBOARD_STRETCH);
    }

    public void startStretchDashboard(InputView inputView) {

        while (power) {
            showOptions();

            String chosenOption = makeUserChooseOption(inputView);

            startChosenOption(chosenOption);

        }
    }

    public String makeUserChooseOption(InputView inputView) {
        while (true) {
            String optionChosen = chooseOption(inputView);
            try {
                checkOptions(optionChosen);
                return optionChosen;
            } catch (Exception e) {
                System.out.println(ERROR_OPTION_UNAVAILABLE);
            }
        }
    }

    public void checkOptions(String input) throws Exception {
        if (!options.containsKey(input)) {
            throw new Exception();
        }
    }

    public void startChosenOption(String option) {

        if (option.equals(OPTION_NUM_1)) {
            insertStretch(inputView);
        }
        if (option.equals(OPTION_NUM_2)) {
            deleteStretch(inputView);
        }
        if (option.equals(OPTION_BACK)) {
            power = false;
        }
    }

    public void showOptions() {
        showStretchDashboardName();
        Set set = options.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry e = (Map.Entry) iterator.next();
            System.out.printf("%s. %s\n", e.getKey(), e.getValue());
        }
        System.out.println("");
    }

    public String chooseOption(InputView inputView) {
        return inputView.readOptionChoice();
    }

    public void insertStretch(InputView inputView) {
        Line chosenLine = insertLineName();
        Station newStation = insertStationName(chosenLine);
        if (newStation == null) {
            return;
        }

        insertPosition(chosenLine, newStation);
    }

    public Line insertLineName() {
        while (true) {
            String chosenLineName = inputView.readLineName();
            if (validLineNameSubmitted(new Line(chosenLineName))) {
                return LineRepository.getLineByName(chosenLineName);
            }
        }
    }

    public Station insertStationName(Line chosenLine) {
        Station newStation = new Station(inputView.readStationName());
        if (chosenLine.getStations().contains(newStation)) {
            System.out.println(ERROR_STATION_NAME_DUPLICATED);
            return null;
        }
        return newStation;
    }

    public void insertPosition(Line chosenLine, Station newStation) {
        String tempOrder = inputView.readStationOrder();
        try {
            int order = Integer.parseInt(tempOrder);
            if (order < 0 || order > chosenLine.getStations().size()) {
                System.out.println(ERROR_ORDER_OUT_OF_RANGE);
                return;
            }
            StationRepository.addStation(newStation);
            chosenLine.getStations().add(order, newStation);
            System.out.println(INFO_STRETCH_INSERT_SUCCESS);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_ORDER_OUT_OF_RANGE);
            return;
        }
    }

    public void deleteStretch(InputView inputView) {
        Line chosenLine;
        while (true) {
            String chosenLineName = inputView.readDeletingLineName();
            if (validLineNameSubmitted(new Line(chosenLineName))) {
                chosenLine = LineRepository.getLineByName(chosenLineName);
                break;
            }
        }
        if (!checkCanDeleteStationFromLine(chosenLine)) {
            return;
        }
        String chosenStationName = inputView.readDeletingStationName();
        deleteChosenStretch(chosenLine, chosenStationName);
    }

    public boolean checkCanDeleteStationFromLine(Line chosenLine) {
        if (chosenLine.getStations().size() < 3) {
            System.out.println(ERROR_CANNOT_DELETE_TERMINAL_STATION);
            return false;
        }
        return true;
    }


    public boolean validLineNameSubmitted(Line line) {
        if (LineRepository.lines().contains(line)) {
            return true;
        }
        System.out.println(ERROR_LINE_NAME_NO_EXISTS);
        return false;
    }


    public void deleteChosenStretch(Line chosenLine, String stationName) {
        if (chosenLine.getStations()
            .removeIf(station -> Objects.equals(station.getName(), stationName))) {
            StationRepository.getStationByName(stationName).subtractNumberOnLines();
            checkOnLineStatus(stationName);
            System.out.println(INFO_STRETCH_DELETE_SUCCESS);
            return;
        }
        System.out.println(ERROR_STATION_NAME_NO_EXISTS);
    }

    public void checkOnLineStatus(String stationName) {
        if (StationRepository.getStationByName(stationName).isNotOnLines()) {
            try {
                StationRepository.deleteStation(stationName);
            } catch (ExceptionStationNameNoExists e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
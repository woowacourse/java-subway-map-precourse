package subway.dashboard;

import static subway.dashboard.DashboardWords.*;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;

public class LineDashboard {

    TreeMap<String, String> options;
    InputView inputView;
    boolean power;
    public LineDashboard(InputView inputView) {
        this.inputView = inputView;
        power = true;
        options = new TreeMap<>();
        options.put(OPTION_NUM_1, DASHBOARD_LINE_OPTION_1);
        options.put(OPTION_NUM_2, DASHBOARD_LINE_OPTION_2);
        options.put(OPTION_NUM_3, DASHBOARD_LINE_OPTION_3);
        options.put(OPTION_BACK, DASHBOARD_OPTION_B);
        startLineDashboard(inputView);

    }

    public void showLineDashboardName() {
        System.out.println(DASHBOARD_STATION);
    }

    public void startLineDashboard(InputView inputView) {

        while(power) {
            showOptions();

            String chosenOption = makeUserChooseOption(inputView);

            startChosenOption(chosenOption);

        }
    }

    public String makeUserChooseOption(InputView inputView) {
        while(true) {
            String optionChosen = chooseOption(inputView);
            try{
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
            if (startOption1(inputView)) {
            }
        }

        if (option.equals(OPTION_NUM_2)) {
            if (startOption2(inputView)) {
            }
        }

        if (option.equals(OPTION_NUM_3)) {
            showLines();
            System.out.println();
        }

        if (option.equals(OPTION_BACK)) {
            power = false;
        }
    }

    public boolean startOption1(InputView inputView) {
        if (updateLine(inputView)) {
            System.out.println();
            return true;
        }
        System.out.println(INFO_LINE_ENROLL_SUCCESS);
        System.out.println();
        return false;
    }

    public boolean startOption2(InputView inputView) {
        if (deleteLine(inputView)) {
            System.out.println();
            return true;
        }
        System.out.println(INFO_LINE_DELETE_SUCCESS);
        System.out.println();
        return false;
    }

    public void showOptions() {
        showLineDashboardName();
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

    public boolean updateLine(InputView inputView) {
        String submittedLineName = inputView.readLineName();
        if (submittedLineName.length() < 2) {
            System.out.println(ERROR_NAME_LENGTH);
            return true;
        }
        Line line = new Line(submittedLineName);
        if (LineRepository.lines().contains(line)) {
            System.out.println(ERROR_LINE_NAME_DUPLICATED);
            return true;
        }
        LineRepository.addLine(line);
        setFirstStation(inputView, line);
        setLastStation(inputView, line);

        return false;
    }

    public void setFirstStation(InputView inputView, Line line) {
        Station station;
        while (true) {
            station = new Station(inputView.readFirstStationName());
            if (canAddStation(line, station)) {
                break;
            }
        }
        StationRepository.addStation(station);
        line.addStation(station);

    }

    public void setLastStation(InputView inputView, Line line) {
        Station station;
        while (true) {
            station = new Station(inputView.readLastStationName());
            if (canAddStation(line, station)) {
                break;
            }
        }
        StationRepository.addStation(station);
        line.addStation(station);
    }

    public boolean canAddStation(Line line, Station station) {
        if (line.getStations().contains(station)) {
            System.out.println(ERROR_STATION_NAME_DUPLICATED);
            return false;
        }
        if (station.getName().length() < 2) {
            System.out.println(ERROR_NAME_LENGTH);
            return false;
        }
        return true;
    }

    public boolean deleteLine(InputView inputView) {
        String submittedLineName = inputView.readDeletingLineName();
        if (!LineRepository.deleteLineByName(submittedLineName)) {
            System.out.println(ERROR_LINE_NAME_NO_EXISTS);
            return true;
        }
        return false;
    }

    public void showLines() {
        System.out.println(LIST_OF_LINES);
        for (Line line : LineRepository.lines()) {
            System.out.print(INFO);
            System.out.println(line);
        }
    }

}
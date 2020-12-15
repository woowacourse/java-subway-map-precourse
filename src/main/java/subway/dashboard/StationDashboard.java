package subway.dashboard;

import static subway.dashboard.DashboardWords.*;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import subway.SubwayExceptions.ExceptionCannotDeleteStationOnLine;
import subway.SubwayExceptions.ExceptionStationNameNoExists;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;

public class StationDashboard {

    TreeMap<String, String> options;
    InputView inputView;
    boolean power;

    public StationDashboard(InputView inputView) {
        this.inputView = inputView;
        options = new TreeMap<>();
        power = true;
        options.put(OPTION_NUM_1, DASHBOARD_STATION_OPTION_1);
        options.put(OPTION_NUM_2, DASHBOARD_STATION_OPTION_2);
        options.put(OPTION_NUM_3, DASHBOARD_STATION_OPTION_3);
        options.put(OPTION_BACK, DASHBOARD_OPTION_B);
        startStationDashboard(inputView);

    }

    public void showStationDashboardName() {
        System.out.println(DASHBOARD_STATION);
    }

    public void startStationDashboard(InputView inputView) {

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
            showStations();
            System.out.println();
        }
        if (option.equals(OPTION_BACK)) {
            power = false;
        }
    }

    public boolean startOption1(InputView inputView) {
        if (updateStation(inputView)) {
            System.out.println();
            return true;
        }
        System.out.println(INFO_STATION_ENROLL_SUCCESS);
        System.out.println();
        return false;
    }

    public boolean startOption2(InputView inputView) {
        if (!deleteStation(inputView)) {
            System.out.println();
            return true;
        }
        System.out.println(INFO_STATION_DELETE_SUCCESS);
        System.out.println();
        return false;
    }

    public void showOptions() {
        showStationDashboardName();
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

    public boolean updateStation(InputView inputView) {
        String submittedStationName = inputView.readStationName();
        if (submittedStationName.length() < 2) {
            System.out.println(ERROR_NAME_LENGTH);
            return true;
        }
        Station station = new Station(submittedStationName);
        if (StationRepository.stations().contains(station)) {
            System.out.println(ERROR_STATION_NAME_DUPLICATED);
            return true;
        }
        StationRepository.addStation(station);
        return false;
    }

    public boolean deleteStation(InputView inputView) {
        String submittedStationName = inputView.readDeletingStationName();
        try {
            StationRepository.canDeleteStation(submittedStationName);
            StationRepository.deleteStation(submittedStationName);
        } catch (ExceptionCannotDeleteStationOnLine e) {
            System.out.println(e.getMessage());
            return false;
        } catch (ExceptionStationNameNoExists e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void showStations() {
        System.out.println(LIST_OF_STATIONS);
        for (Station station : StationRepository.stations()) {
            System.out.print(INFO);
            System.out.println(station);
        }
    }


}
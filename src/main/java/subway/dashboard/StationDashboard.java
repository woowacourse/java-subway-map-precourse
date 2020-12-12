package subway.dashboard;

import static subway.dashboard.DashboardWords.*;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import subway.view.InputView;

public class StationDashboard {
    TreeMap<String, String> options;
    InputView inputView;

    public StationDashboard(InputView inputView) {
        this.inputView = inputView;
        options = new TreeMap<>();
        options.put(OPTION_NUM_1, DASHBOARD_STATION_OPTION_1);
        options.put(OPTION_NUM_2, DASHBOARD_STATION_OPTION_2);
        options.put(OPTION_NUM_3, DASHBOARD_STATION_OPTION_3);
        options.put(OPTION_BACK, DASHBOARD_OPTION_B);
        showStationDashboardName();
        startStationDashboard(inputView);

    }

    public void showStationDashboardName() {
        System.out.println(DASHBOARD_STATION);
    }

    public void startStationDashboard(InputView inputView) {
        while(true) {
            if (!startChosenOptionUntilFinished(makeUserChooseOption(inputView))) {
                break;
            }
        }
    }

    public String makeUserChooseOption(InputView inputView) {
        showOptions();
        String optionChosen;
        while(true) {
            optionChosen = chooseOption(inputView);
            if (checkOptions(optionChosen)) {
                return optionChosen;
            }
        }
    }

    public boolean checkOptions(String input) {
        if (options.containsKey(input)) {
            return true;
        }
        System.out.println(ERROR_OPTION_UNAVAILABLE);
        return false;
    }

    public boolean startChosenOptionUntilFinished(String option) {

        if (option.equals(OPTION_NUM_1)) {
            System.out.println("역등록실행");
            return false;
        }
        if (option.equals(OPTION_NUM_2)) {
            System.out.println("역삭제실행");
            return false;
        }
        if (option.equals(OPTION_NUM_3)) {
            System.out.println("역조회실행");
            return false;
        }
        return false;
    }

    public void showOptions() {
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


}
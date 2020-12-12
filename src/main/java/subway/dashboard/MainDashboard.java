package subway.dashboard;

import static subway.dashboard.DashboardWords.*;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import subway.view.InputView;

public class MainDashboard {
    TreeMap<String, String> options;
    InputView inputView;
    public MainDashboard(InputView inputView) {
        this.inputView = inputView;
        options = new TreeMap<>();
        options.put(OPTION_NUM_1, DASHBOARD_MAIN_OPTION_1);
        options.put(OPTION_NUM_2, DASHBOARD_MAIN_OPTION_2);
        options.put(OPTION_NUM_3, DASHBOARD_MAIN_OPTION_3);
        options.put(OPTION_NUM_4, DASHBOARD_MAIN_OPTION_4);
        options.put(OPTION_QUIT, DASHBOARD_OPTION_Q);
        startMainDashboard(inputView);

    }

    public void showDashboardName() {
        System.out.println(DASHBOARD_MAIN);
    }

    public void startMainDashboard(InputView inputView) {
        while(true) {
            if (!startChosenOptionUntilFinished(makeUserChooseOption(inputView))) {
                break;
            }
        }
    }

    public String makeUserChooseOption(InputView inputView) {
        showDashboardName();
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
            StationDashboard stationDashboard = new StationDashboard(inputView);
            return true;
        }

        if (option.equals(OPTION_NUM_2)) {
            LineDashboard lineDashboard = new LineDashboard(inputView);
            return true;
        }

        if (option.equals(OPTION_NUM_3)) {
            StretchDashboard stretchDashboard = new StretchDashboard(inputView);
            return true;
        }

        if (option.equals(OPTION_NUM_4)) {
            LineMapPrinterDashboard lineMapPrinterDashboard = new LineMapPrinterDashboard();
            return true;
        }

        System.out.println("[INFO] 노선도 서비스를 종료합니다");
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
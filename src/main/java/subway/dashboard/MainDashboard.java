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
    boolean power;
    public MainDashboard(InputView inputView) {
        this.inputView = inputView;
        power = true;
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

        while(power) {
            showOptions();

            String chosenOption = makeUserChooseOption(inputView);

            startChosenOption(chosenOption);

        }
    }

    public String makeUserChooseOption(InputView inputView) {
        String optionChosen = chooseOption(inputView);
        try{
            checkOptions(optionChosen);
        } catch (Exception e) {
            System.out.println(ERROR_OPTION_UNAVAILABLE);
            makeUserChooseOption(inputView);
        }

        return optionChosen;
    }

    public void checkOptions(String input) throws Exception {
        if (!options.containsKey(input)) {
            throw new Exception();
        }
    }

    public void startChosenOption(String option) {
        if (option.equals(OPTION_NUM_1)) {
            StationDashboard stationDashboard = new StationDashboard(inputView);
        }

        if (option.equals(OPTION_NUM_2)) {
            LineDashboard lineDashboard = new LineDashboard(inputView);
        }

        if (option.equals(OPTION_NUM_3)) {
            StretchDashboard stretchDashboard = new StretchDashboard(inputView);
        }

        if (option.equals(OPTION_NUM_4)) {
            LineMapPrinterDashboard lineMapPrinterDashboard = new LineMapPrinterDashboard();
        }

        if (option.equals(OPTION_QUIT)) {
            power = false;
            System.out.println("[INFO] 노선도 서비스를 종료합니다");
        }
    }

    public void showOptions() {
        showDashboardName();
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
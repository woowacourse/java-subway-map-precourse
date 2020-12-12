package subway.dashboard;

import static subway.dashboard.DashboardWords.*;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.InputView;

public class StretchDashboard {
    TreeMap<String, String> options;
    InputView inputView;

    public StretchDashboard(InputView inputView) {
        this.inputView = inputView;
        options = new TreeMap<>();
        options.put(OPTION_NUM_1, DASHBOARD_STRETCH_OPTION_1);
        options.put(OPTION_NUM_2, DASHBOARD_STRETCH_OPTION_2);
        options.put(OPTION_BACK, DASHBOARD_OPTION_B);
        showStretchDashboardName();
        startStretchDashboard(inputView);

    }

    public void showStretchDashboardName() {
        System.out.println(DASHBOARD_STRETCH);
    }

    public void startStretchDashboard(InputView inputView) {
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
            System.out.println("구간등록실행");
            return false;
        }
        if (option.equals(OPTION_NUM_2)) {
            deleteStretch(inputView);
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

    public void deleteStretch(InputView inputView) {
        Line chosenLine;
//      존재하지 않는 노선 입력시 다시 입력받도록 함
        while(true) {
            String chosenLineName = inputView.readDeletingLineName();
            if (validLineNameSubmitted(new Line(chosenLineName))) {
                chosenLine = pushChosenLine(chosenLineName);
                break;
            }
        }
//        존재하지 않는 역 이름 입력시 종료시킴
        String chosenStationName = inputView.readDeletingStationName();
        deleteChosenStretch(chosenLine,chosenStationName);

    }

    public boolean validLineNameSubmitted(Line line) {
        if(LineRepository.lines().contains(line)) {
            return true;
        }
        System.out.println(ERROR_LINE_NAME_NO_EXISTS);
        return false;
    }

    public Line pushChosenLine(String lineName) {
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(lineName)) {
                return line;
            }
        }
        return null;
    }

    public void deleteChosenStretch(Line chosenLine, String StationName) {
        if(chosenLine.getStations().removeIf(station -> Objects.equals(station.getName(), StationName))) {
            System.out.println(INFO_STRETCH_DELETE_SUCCESS);
            return;
        }
        System.out.println(ERROR_STATION_NAME_NO_EXISTS);
    }



}
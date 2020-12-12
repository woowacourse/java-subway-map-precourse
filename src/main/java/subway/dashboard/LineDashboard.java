package subway.dashboard;

import static subway.dashboard.DashboardWords.*;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.view.InputView;

public class LineDashboard {
    TreeMap<String, String> options;
    InputView inputView;

    public LineDashboard(InputView inputView) {
        this.inputView = inputView;
        options = new TreeMap<>();
        options.put(OPTION_NUM_1, DASHBOARD_LINE_OPTION_1);
        options.put(OPTION_NUM_2, DASHBOARD_LINE_OPTION_2);
        options.put(OPTION_NUM_3, DASHBOARD_LINE_OPTION_3);
        options.put(OPTION_BACK, DASHBOARD_OPTION_B);
        showLineDashboardName();
        startLineDashboard(inputView);

    }

    public void showLineDashboardName() {
        System.out.println(DASHBOARD_LINE);
    }

    public void startLineDashboard(InputView inputView) {
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
            if (updateLine(inputView)) {
                return true;
            }
            return false;
        }
        if (option.equals(OPTION_NUM_2)) {
            System.out.println("노선삭제실행");
            return false;
        }
        if (option.equals(OPTION_NUM_3)) {
            System.out.println("노선조회실행");
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

    public boolean updateLine(InputView inputView) {
        String submittedLinName = inputView.readLineName();
        Line line = new Line(submittedLinName);
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
        Station station = new Station(inputView.readFirstStationName());
        while(true) {
            if(canAddStation(line, station)) {
                break;
            }
        }
        line.addStation(station);

    }

    public void setLastStation(InputView inputView, Line line) {
        Station station = new Station(inputView.readLastStationName());
        while(true) {
            if(canAddStation(line, station)) {
                break;
            }
            System.out.println(ERROR_STATION_NAME_DUPLICATED);
            station = new Station(inputView.readLastStationName());
        }
        line.addStation(station);
    }

    public boolean canAddStation(Line line, Station station) {
        if (line.getStations().contains(station)) {
            return false;
        }
        return true;
    }


}
package subway.line;

import subway.common.SelectOption;
import subway.line.validation.CheckRegisteredLine;
import subway.line.validation.NotAllowSameStartEnd;
import subway.station.Station;
import subway.station.StationService;
import subway.view.InputView;
import subway.view.line.LineManagementView;

import java.util.Arrays;
import java.util.List;

public class LineController {
    private static final char ADD_LINE = '1';
    private static final char DELETE_LINE = '2';
    private static final char PRINT_LINE = '3';
    private static final char GO_BACK = 'B';

    public static void lineManagement(InputView inputView) {
        List<Character> optionList = Arrays.asList(ADD_LINE, DELETE_LINE, PRINT_LINE, GO_BACK);

        while (true) {
            LineManagementView.showLineManagementMenu();
            char option = SelectOption.choice(optionList, inputView);

            if (option == GO_BACK) {
                break;
            }

            if (selectOption(option, inputView)) {
                break;
            }
        }
    }

    private static boolean selectOption(char option, InputView inputView) {
        try {
            if (option == ADD_LINE) {
                return addNewLine(inputView);
            }
            if (option == DELETE_LINE) {
                return deleteLine(inputView);
            }
            if (option == PRINT_LINE) {
                return printRegisteredLine();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static boolean addNewLine(InputView inputView) {
        Line line = getNewLine(inputView);
        Station startStation = getStartStation(inputView);
        Station endStation = getEndStation(startStation, inputView);

        LineService.addLineWithStartEndStation(line, startStation, endStation);

        LineManagementView.addLineComplete();
        return true;
    }

    private static Line getNewLine(InputView inputView) {
        LineManagementView.askNewLineName();
        String lineName = inputView.lineName();
        return new Line(lineName);
    }

    private static Station getStartStation(InputView inputView) {
        LineManagementView.askStartStationName();
        String startStationName = inputView.stationName();
        return StationService.findStation(startStationName);
    }

    private static Station getEndStation(Station startStation, InputView inputView) {
        LineManagementView.askEndStationName();
        String endStationName = inputView.stationName();
        NotAllowSameStartEnd.validation(startStation.getName(), endStationName);
        return StationService.findStation(endStationName);
    }

    private static boolean deleteLine(InputView inputView) {
        LineManagementView.askDeleteLineName();
        String lineName = inputView.lineName();

        CheckRegisteredLine.validation(lineName);
        LineService.deleteLine(lineName);

        LineManagementView.deleteLineComplete();
        return true;
    }

    private static boolean printRegisteredLine() {
        List<Line> lines = LineService.allLine();
        LineManagementView.showAllLine(lines);
        return true;
    }
}

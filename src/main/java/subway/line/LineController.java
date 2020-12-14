package subway.line;

import subway.line.view.LineInputView;
import subway.line.view.LineOutputView;
import subway.main.view.MainInputView;
import subway.station.view.StationInputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LineController {
    private static final char ADD_LINE = '1';
    private static final char DELETE_LINE = '2';
    private static final char PRINT_LINE = '3';
    private static final char GO_BACK = 'B';
    private static final char ADD_SECTION = '1';
    private static final char DELETE_SECTION = '2';

    public static void lineManagement(MainInputView mainInputView) {
        List<Character> optionList = Arrays.asList(ADD_LINE, DELETE_LINE, PRINT_LINE, GO_BACK);

        while (true) {
            LineOutputView.printLineManagement();
            char option = mainInputView.selectOption(optionList);

            if (option == GO_BACK) {
                break;
            }

            if (selectLineManagementOption(option, mainInputView.getScanner())) {
                break;
            }
        }
    }

    public static void sectionManagement(MainInputView mainInputView) {
        List<Character> optionList = Arrays.asList(ADD_SECTION, DELETE_SECTION, GO_BACK);

        while (true) {
            LineOutputView.printSectionManagement();
            char option = mainInputView.selectOption(optionList);

            if (option == GO_BACK) {
                break;
            }

            if (selectSectionManagementOption(option, mainInputView.getScanner())) {
                break;
            }
        }
    }

    private static boolean selectSectionManagementOption(char option, Scanner scanner) {
        LineInputView lineInputView = new LineInputView(scanner);
        StationInputView stationInputView = new StationInputView(scanner);

        if (option == ADD_SECTION) {
            return addNewSection(lineInputView, stationInputView);
        }
        if (option == DELETE_SECTION) {
            return deleteSection(lineInputView, stationInputView);
        }
        return false;
    }

    private static boolean deleteSection(LineInputView lineInputView, StationInputView stationInputView) {
        String lineName = lineInputView.deleteSectionLine();
        return LineService.deleteSection(lineName, stationInputView);
    }

    private static boolean addNewSection(LineInputView lineInputView, StationInputView stationInputView) {
        String lineName = lineInputView.lineName();
        return LineService.addSection(lineName, lineInputView, stationInputView);
    }

    private static boolean selectLineManagementOption(char option, Scanner scanner) {
        LineInputView lineInputView = new LineInputView(scanner);

        if (option == ADD_LINE) {
            return addNewLine(lineInputView);
        }
        if (option == DELETE_LINE) {
            return deleteLine(lineInputView);
        }
        if (option == PRINT_LINE) {
            return printRegisteredLine();
        }
        return false;
    }

    private static boolean addNewLine(LineInputView lineInputView) {
        String lineName = lineInputView.newLineName();
        return LineService.addLine(lineName, lineInputView);
    }

    private static boolean deleteLine(LineInputView lineInputView) {
        String lineName = lineInputView.deleteLineName();
        return LineService.deleteLine(lineName);
    }

    private static boolean printRegisteredLine() {
        return LineService.printAllLine();
    }

    public static void printSubwayMap() {
        LineService.printAllLineInformation();
    }
}

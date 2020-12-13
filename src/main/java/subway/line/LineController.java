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

        LineOutputView.printLineManagement();
        selectLineManagementOption(mainInputView.selectOption(optionList), mainInputView.getScanner());
    }

    public static void sectionManagement(MainInputView mainInputView) {
        List<Character> optionList = Arrays.asList(ADD_SECTION, DELETE_SECTION, GO_BACK);

        LineOutputView.printSectionManagement();
        selectSectionManagementOption(mainInputView.selectOption(optionList), mainInputView.getScanner());
    }

    private static void selectSectionManagementOption(char option, Scanner scanner) {
        LineInputView lineInputView = new LineInputView(scanner);
        StationInputView stationInputView = new StationInputView(scanner);

        if (option == ADD_SECTION) {
            addNewSection(lineInputView, stationInputView);
        }
        if (option == DELETE_SECTION) {
            deleteSection(lineInputView, stationInputView);
        }
    }

    private static void deleteSection(LineInputView lineInputView, StationInputView stationInputView) {
        String lineName = lineInputView.deleteSectionLine();
        LineService.deleteSection(lineName, stationInputView);
    }

    private static void addNewSection(LineInputView lineInputView, StationInputView stationInputView) {
        String lineName = lineInputView.lineName();
        LineService.addSection(lineName, lineInputView, stationInputView);
    }

    private static void selectLineManagementOption(char option, Scanner scanner) {
        LineInputView lineInputView = new LineInputView(scanner);

        if (option == ADD_LINE) {
            addNewLine(lineInputView);
        }
        if (option == DELETE_LINE) {
            deleteLine(lineInputView);
        }
        if (option == PRINT_LINE) {
            printRegisteredLine();
        }
    }

    private static void addNewLine(LineInputView lineInputView) {
        String lineName = lineInputView.newLineName();
        LineService.addLine(lineName, lineInputView);
    }

    private static void deleteLine(LineInputView lineInputView) {
        String lineName = lineInputView.deleteLineName();
        LineService.deleteLine(lineName);
    }

    private static void printRegisteredLine() {
        LineOutputView.printAllLine();
    }
}

package subway.line;

import subway.line.view.LineInputView;
import subway.line.view.LineOutputView;
import subway.main.view.MainInputView;
import subway.station.Station;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LineController {
    private static final char ADD_LINE = '1';
    private static final char DELETE_LINE = '2';
    private static final char PRINT_LINE = '3';
    private static final char GO_BACK = 'B';

    public static void lineManagement(MainInputView mainInputView) {
        List<Character> optionList = Arrays.asList(ADD_LINE, DELETE_LINE, PRINT_LINE, GO_BACK);

        LineOutputView.printLineManagement();
        selectOption(mainInputView.selectOption(optionList), mainInputView.getScanner());
    }

    private static void selectOption(char option, Scanner scanner) {
        LineInputView lineInputView = new LineInputView(scanner);

        if (option == ADD_LINE) {
            addNewLine(lineInputView);
        }
    }

    private static void addNewLine(LineInputView lineInputView) {
        String lineName = lineInputView.newLineName();
        LineService.addLine(lineName, lineInputView);
    }
}

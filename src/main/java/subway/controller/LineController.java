package subway.controller;

import subway.service.LineService;
import subway.service.StationService;
import subway.view.InputView;

import java.util.Arrays;
import java.util.List;

import static subway.view.OutputView.printMenuMessage;
import static subway.view.OutputView.warnMessage;

public class LineController {
    private final String LINE_MENU = "노선 관리 화면";
    private final String ADD_LINE = "1. 노선 등록";
    private final String DELETE_LINE = "2. 노선 삭제";
    private final String PRINT_LINE = "3. 노선 조회";
    private final String BACK = "B. 돌아가기";
    private final String OPTION_SELECT_WARN = "선택지 안의 기능을 선택해주세요.";
    private final List<String> MENU_MESSAGES =
            Arrays.asList(LINE_MENU, ADD_LINE, DELETE_LINE, PRINT_LINE, BACK);
    private final List<String> MENU_OPTIONS = Arrays.asList("1", "2", "3", "B");

    public void service(InputView inputView) {
        String option;
        while(true) {
            printMenuMessage(MENU_MESSAGES);
            option = inputView.inputName();
            if (!MENU_OPTIONS.contains(option)) {
                warnMessage(OPTION_SELECT_WARN);
                continue;
            }
            if (option.equals(String.valueOf(BACK.charAt(0)))) {
                break;
            }
            menuSelector(option, inputView);
        }
    }

    public void menuSelector(String option, InputView inputView) {
        if (option.equals(String.valueOf(ADD_LINE.charAt(0)))) {
            addLine(inputView);
        }
        if (option.equals(String.valueOf(DELETE_LINE.charAt(0)))) {
            deleteLine(inputView);
        }
        if (option.equals(String.valueOf(PRINT_LINE.charAt(0)))) {
            printLine();
        }
    }

    public void addLine(InputView inputView) {
        new LineService().addLine(inputView);
    }

    public void deleteLine(InputView inputView) {
        new LineService().deleteLine(inputView);
    }

    public void printLine() {
        new LineService().printLineList();
    }
}

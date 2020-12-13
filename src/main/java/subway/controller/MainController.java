package subway.controller;

import subway.repository.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static subway.repository.LineRepository.*;
import static subway.view.OutputView.*;

public class MainController {
    private final String MAIN_MENU = "메인 화면";
    private final String STATION_CONTROLLER = "1. 역 관리";
    private final String LINE_CONTROLLER = "2. 노선 관리";
    private final String SECTION_CONTROLLER = "3. 구간 관리";
    private final String PRINT_SUBWAY = "4. 지하철 노선도 출력";
    private final String EXIT = "Q. 종료";
    private final String OPTION_SELECT_WARN = "선택지 안의 기능을 선택해주세요.";
    private final List<String> MENU_MESSAGES =
            Arrays.asList(MAIN_MENU, STATION_CONTROLLER, LINE_CONTROLLER, SECTION_CONTROLLER, PRINT_SUBWAY, EXIT);
    private final List<String> MENU_OPTIONS = Arrays.asList("1", "2", "3", "4", "Q");


    public void service(InputView inputView) {
        String option;
        while(true) {
            printMenuMessage(MENU_MESSAGES);
            option = inputView.inputName();
            if (!MENU_OPTIONS.contains(option)) {
                warnMessage(OPTION_SELECT_WARN);
                continue;
            }
            if (option.equals(String.valueOf(EXIT.charAt(0)))) {
                break;
            }
            menuSelector(option, inputView);
        }
    }

    public void menuSelector(String option, InputView inputView) {
        if (option.equals(String.valueOf(STATION_CONTROLLER.charAt(0)))) {
            new StationController().service(inputView);
        }
        if (option.equals(String.valueOf(LINE_CONTROLLER.charAt(0)))) {
            new LineController().service(inputView);
        }
        if (option.equals(String.valueOf(SECTION_CONTROLLER.charAt(0)))) {
            new SectionController().service(inputView);
        }
        if (option.equals(String.valueOf(PRINT_SUBWAY.charAt(0)))) {
            printLineAndStation();
        }
    }
}

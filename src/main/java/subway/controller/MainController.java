package subway.controller;

import subway.view.InputView;

import java.util.Arrays;
import java.util.List;

import static subway.common.ControllerMenu.*;
import static subway.repository.LineRepository.printLineAndStation;
import static subway.view.OutputView.printMenuMessage;
import static subway.view.OutputView.warnMessage;

public class MainController {
    private final String MAIN_MENU = "메인 화면";
    private final String STATION_CONTROLLER = "1. 역 관리";
    private final String LINE_CONTROLLER = "2. 노선 관리";
    private final String SECTION_CONTROLLER = "3. 구간 관리";
    private final String PRINT_SUBWAY = "4. 지하철 노선도 출력";
    private final String EXIT = "Q. 종료";
    private final String COMMAND_SELECT_WARN = "선택지 안의 기능을 선택해주세요.";
    private final List<String> MENU_MESSAGES =
            Arrays.asList(MAIN_MENU, STATION_CONTROLLER, LINE_CONTROLLER, SECTION_CONTROLLER, PRINT_SUBWAY, EXIT);


    public void service(InputView inputView) {
        String command;
        while(true) {
            printMenuMessage(MENU_MESSAGES);
            command = inputView.inputName();
            if (isValidCommand(command)) {
                warnMessage(COMMAND_SELECT_WARN);
                continue;
            }
            if (isExitCommand(command)) {
                break;
            }
            menuSelector(command, inputView);
        }
    }

    public void menuSelector(String command, InputView inputView) {
        if (isStationControllerCommand(command)) {
            new StationController().service(inputView);
        }
        if (isLineControllerCommand(command)) {
            new LineController().service(inputView);
        }
        if (isSectionControllerCommand(command)) {
            new SectionController().service(inputView);
        }
        if (isPrintSubwayCommand(command)) {
            printLineAndStation();
        }
    }
}

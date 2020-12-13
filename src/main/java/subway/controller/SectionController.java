package subway.controller;

import subway.service.SectionService;
import subway.service.StationService;
import subway.view.InputView;

import java.util.Arrays;
import java.util.List;

import static subway.view.OutputView.printMenuMessage;
import static subway.view.OutputView.warnMessage;

public class SectionController {
    private final String SECTION_MENU = "구간 관리 화면";
    private final String ADD_SECTION = "1. 구간 등록";
    private final String DELETE_SECTION = "2. 구간 삭제";
    private final String BACK = "B. 돌아가기";
    private final String OPTION_SELECT_WARN = "선택지 안의 기능을 선택해주세요.";
    private final List<String> MENU_MESSAGES =
            Arrays.asList(SECTION_MENU, ADD_SECTION, DELETE_SECTION, BACK);
    private final List<String> MENU_OPTIONS = Arrays.asList("1", "2", "B");

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
        if (option.equals(String.valueOf(ADD_SECTION.charAt(0)))) {
            addSection(inputView);
        }
        if (option.equals(String.valueOf(DELETE_SECTION.charAt(0)))) {
            deleteSection(inputView);
        }
    }

    public void addSection(InputView inputView) {
        new SectionService().addSection(inputView);
    }

    public void deleteSection(InputView inputView) {
        new SectionService().deleteSection(inputView);
    }
}

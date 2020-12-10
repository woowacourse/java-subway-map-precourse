package subway.view;

import java.util.Arrays;
import subway.controller.Management;
import subway.exception.SubwayCustomException;

public enum MainMenu {
    MANAGE_STATION("1", Management::manageStation),
    MANAGE_LINE("2", Management::manageLine),
    MANAGE_SECTION("3", Management::mangeSection),
    MANAGE_SUBWAY("4", OutputView::showSubwayLineMap),
    MANAGE_QUIT("Q", MainMenu::end);


    public static final String WRONG_MENU_INPUT_EXCEPTION_MESSAGE = "선택할 수 없는 기능입니다.";
    private final String input;
    private final Runnable handler;

    MainMenu(String input, Runnable handler) {
        this.input = input;
        this.handler = handler;
    }

    public static void execute(String input) {
        Arrays.stream(values())
            .filter(value -> value.input.equals(input))
            .findFirst()
            .orElseThrow(() -> new SubwayCustomException(WRONG_MENU_INPUT_EXCEPTION_MESSAGE))
            .handler.run();
    }

    private static void end() {
        System.exit(0);
    }
}


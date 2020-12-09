package subway.view;

import subway.domain.State;

import java.util.Scanner;

public class InputView {
    private static final String SCENE_FIRST = "1";
    private static final String SCENE_SECOND = "2";
    private static final String SCENE_THIRD = "3";
    private static final String SCENE_FORTH = "4";
    private static final String SCENE_QUIT = "q";
    private static final String SCENE_QUIT_UPPER = "Q";
    private static final String SCENE_BACK = "b";
    private static final String SCENE_BACK_UPPER = "B";
    private static final String INVALID_CHOICE_MESSAGE = "[ERROR] 선택할 수 없는 기능입니다.";

    public static State inputSceneChoice(Scanner scanner) {
        return getMainSceneChoice(scanner.next());
    }

    public static String inputStationName(Scanner scanner) {
        return scanner.next();
    }

    public static String inputLineName(Scanner scanner) {
        return scanner.next();
    }

    private static State getMainSceneChoice(String value) {
        if (value.equals(SCENE_QUIT) || value.equals(SCENE_QUIT_UPPER)) {
            return State.QUIT;
        }

        return getMainSceneMenu(value);
    }

    private static State getMainSceneMenu(String value) {
        if (value.equals(SCENE_FIRST)) {
            return State.STATION_SCENE;
        }

        if (value.equals(SCENE_SECOND)) {
            return State.LINE_SCENE;
        }

        if (value.equals(SCENE_THIRD)) {
            return State.SECTION_SCENE;
        }

        if (value.equals(SCENE_FORTH)) {
            return State.MAP_SCENE;
        }

        throw new IllegalArgumentException(INVALID_CHOICE_MESSAGE);
    }
}

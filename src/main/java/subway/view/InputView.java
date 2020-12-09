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

    public static State inputMainSceneChoice(Scanner scanner) {
        return getMainSceneChoice(scanner.next());
    }

    public static State inputStationSceneChoice(Scanner scanner) {
        return getStationSceneChoice(scanner.next());
    }

    public static State inputLineSceneChoice(Scanner scanner) {
        return getLineSceneChoice(scanner.next());
    }

    public static State inputSectionSceneChoice(Scanner scanner) {
        return getSectionSceneChoice(scanner.next());
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

    private static State getStationSceneChoice(String value) {
        if (value.equals(SCENE_BACK) || value.equals(SCENE_BACK_UPPER)) {
            return State.BACK;
        }

        return getStationSceneMenu(value);
    }

    private static State getStationSceneMenu(String value) {
        if (value.equals(SCENE_FIRST)) {
            return State.STATION_ADD;
        }

        if (value.equals(SCENE_SECOND)) {
            return State.STATION_REMOVE;
        }

        if (value.equals(SCENE_THIRD)) {
            return State.STATION_INQUIRY;
        }

        throw new IllegalArgumentException(INVALID_CHOICE_MESSAGE);
    }

    private static State getLineSceneChoice(String value) {
        if (value.equals(SCENE_BACK) || value.equals(SCENE_BACK_UPPER)) {
            return State.BACK;
        }

        return getLineSceneMenu(value);
    }

    private static State getLineSceneMenu(String value) {
        if (value.equals(SCENE_FIRST)) {
            return State.LINE_ADD;
        }

        if (value.equals(SCENE_SECOND)) {
            return State.LINE_REMOVE;
        }

        if (value.equals(SCENE_THIRD)) {
            return State.LINE_INQUIRY;
        }

        throw new IllegalArgumentException(INVALID_CHOICE_MESSAGE);
    }

    private static State getSectionSceneChoice(String value) {
        if (value.equals(SCENE_BACK) || value.equals(SCENE_BACK_UPPER)) {
            return State.BACK;
        }

        return getSectionSceneMenu(value);
    }

    private static State getSectionSceneMenu(String value) {
        if (value.equals(SCENE_FIRST)) {
            return State.SECTION_ADD;
        }

        if (value.equals(SCENE_SECOND)) {
            return State.SECTION_REMOVE;
        }

        if (value.equals(SCENE_THIRD)) {
            return State.SECTION_INQUIRY;
        }

        throw new IllegalArgumentException(INVALID_CHOICE_MESSAGE);
    }
}

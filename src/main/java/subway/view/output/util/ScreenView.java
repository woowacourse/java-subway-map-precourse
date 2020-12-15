package subway.view.output.util;

import subway.type.ScreenType;

/**
 * ScreenView.java : 화면 출력에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class ScreenView {
    public static void printMainScreen() {
        System.out.println(ScreenType.MAIN_SCREEN.getScreen()
                + ScreenType.STATION_MANAGEMENT.getScreen()
                + ScreenType.LINE_MANAGEMENT.getScreen()
                + ScreenType.SECTION_MANAGEMENT.getScreen()
                + ScreenType.SUBWAY_MAP_SHOW.getScreen()
                + ScreenType.QUITTING.getScreen()
                + ScreenType.FEATURE_CHOICE.getScreen());
    }

    public static void printStationManagementScreen() {
        System.out.println(ScreenType.STATION_MANAGEMENT_SCREEN.getScreen()
                + ScreenType.STATION_ADDITION.getScreen()
                + ScreenType.STATION_DELETION.getScreen()
                + ScreenType.STATION_SHOW.getScreen()
                + ScreenType.BACK.getScreen()
                + ScreenType.FEATURE_CHOICE.getScreen());
    }

    public static void printLineManagementScreen() {
        System.out.println(ScreenType.LINE_MANAGEMENT_SCREEN.getScreen()
                + ScreenType.LINE_ADDITION.getScreen()
                + ScreenType.LINE_DELETION.getScreen()
                + ScreenType.LINE_SHOW.getScreen()
                + ScreenType.BACK.getScreen()
                + ScreenType.FEATURE_CHOICE.getScreen());
    }

    public static void printSectionManagementScreen() {
        System.out.println(ScreenType.SECTION_MANAGEMENT_SCREEN.getScreen()
                + ScreenType.SECTION_ADDITION.getScreen()
                + ScreenType.SECTION_DELETION.getScreen()
                + ScreenType.BACK.getScreen()
                + ScreenType.FEATURE_CHOICE.getScreen());
    }

    public static boolean printNewLine() {
        System.out.println();
        return true;
    }
}

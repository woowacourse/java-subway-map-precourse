package subway.view;

import subway.type.ExceptionType;
import subway.type.ScreenType;

public class OutputView {
    public static void printMainScreen() {
        System.out.println(ScreenType.MAIN_SCREEN.getScreen()
                + ScreenType.STATION_MANAGEMENT.getScreen()
                + ScreenType.LINE_MANAGEMENT.getScreen()
                + ScreenType.SECTION_MANAGEMENT.getScreen()
                + ScreenType.SUBWAY_MAP_PRINT.getScreen()
                + ScreenType.QUITTING.getScreen()
                + ScreenType.FEATURE_CHOICE.getScreen());
    }

    public static void printStationManagementScreen() {
        System.out.println(ScreenType.STATION_MANAGEMENT_SCREEN.getScreen()
                + ScreenType.STATION_ADDING.getScreen()
                + ScreenType.STATION_DELETION.getScreen()
                + ScreenType.STATION_PRINT.getScreen()
                + ScreenType.BACK.getScreen()
                + ScreenType.FEATURE_CHOICE.getScreen());
    }

    public static void printLineManagementScreen() {
        System.out.println(ScreenType.LINE_MANAGEMENT_SCREEN.getScreen()
                + ScreenType.LINE_ADDING.getScreen()
                + ScreenType.LINE_DELETION.getScreen()
                + ScreenType.LINE_PRINT.getScreen()
                + ScreenType.BACK.getScreen()
                + ScreenType.FEATURE_CHOICE.getScreen());
    }

    public static void printSectionManagementScreen() {
        System.out.println(ScreenType.SECTION_MANAGEMENT_SCREEN.getScreen()
                + ScreenType.SECTION_ADDING.getScreen()
                + ScreenType.SECTION_DELETION.getScreen()
                + ScreenType.BACK.getScreen()
                + ScreenType.FEATURE_CHOICE.getScreen());
    }

    public static void printInvalidFeatureChoiceException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_FEATURE_CHOICE.getException());
    }
}

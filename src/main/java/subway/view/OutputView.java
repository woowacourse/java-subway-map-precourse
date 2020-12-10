package subway.view;

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
}

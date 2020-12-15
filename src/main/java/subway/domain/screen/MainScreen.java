package subway.domain.screen;

import subway.domain.command.MainCommand;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MainScreen {
    private static final String title = "## 메인 화면\n";

    private static class SingletonHolder {
        private static final MainScreen instance = new MainScreen();
    }

    public static MainScreen getInstance() {
        return MainScreen.SingletonHolder.instance;
    }

    public ScreenType getNextScreen(MainCommand mainCommand) {
        if (mainCommand.isStationManagement()) {
            return ScreenType.STATION_MANAGEMENT;
        }
        if (mainCommand.isLineManagement()) {
            return ScreenType.LINE_MANAGEMENT;
        }
        if (mainCommand.isSectionManagement()) {
            return ScreenType.SECTION_MANAGEMENT;
        }
        if (mainCommand.isSubwayMapPrint()) {
            return ScreenType.SUBWAY_MAP_PRINT;
        }
        return ScreenType.EXIT;
    }

    @Override
    public String toString() {
        String content = Arrays.stream(MainCommand.values())
                .map(command -> command.toString())
                .collect(Collectors.joining());

        return title + content;
    }
}

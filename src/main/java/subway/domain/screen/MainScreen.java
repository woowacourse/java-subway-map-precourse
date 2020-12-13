package subway.domain.screen;

import subway.domain.command.Command;
import subway.domain.command.MainCommand;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MainScreen implements Screen {
    private static final String title = "## 메인 화면\n";

    public static class SingletonHolder {
        private static final Screen instance = new MainScreen();
    }

    public static Screen getInstance() {
        return SingletonHolder.instance;
    }

    @Override
    public String getMessage() {
        String content = Arrays.stream(MainCommand.values())
                .map(command -> command.toString())
                .collect(Collectors.joining());

        return title + content;
    }

    @Override
    public ScreenType getNextScreen(Command command) {
        if (command.equals(MainCommand.STATION_MANAGEMENT)) {
            return ScreenType.STATION_MANAGEMENT;
        }
        if (command.equals(MainCommand.LINE_MANAGEMENT)) {
            return ScreenType.LINE_MANAGEMENT;
        }
        if (command.equals(MainCommand.SECTION_MANAGEMENT)) {
            return ScreenType.SECTION_MANAGEMENT;
        }
        if (command.equals(MainCommand.SUBWAY_MAP_PRINT)) {
            return ScreenType.SUBWAY_MAP_PRINT;
        }
        return ScreenType.EXIT;
    }
}

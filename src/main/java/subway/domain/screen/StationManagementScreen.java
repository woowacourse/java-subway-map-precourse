package subway.domain.screen;

import subway.domain.command.Command;
import subway.domain.command.StationCommand;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StationManagementScreen{
    private static final String title = "## 역 관리 화면\n";

    public static class SingletonHolder {
        private static final StationManagementScreen instance = new StationManagementScreen();
    }

    public static StationManagementScreen getInstance() {
        return StationManagementScreen.SingletonHolder.instance;
    }

    public ScreenType getNextScreen(StationCommand stationCommand) {
        return ScreenType.MAIN;
    }

    @Override
    public String toString() {
        String content = Arrays.stream(StationCommand.values())
                .map(command -> command.toString())
                .collect(Collectors.joining());

        return title + content;
    }
}

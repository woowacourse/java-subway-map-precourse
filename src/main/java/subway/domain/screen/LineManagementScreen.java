package subway.domain.screen;

import subway.domain.command.LineCommand;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LineManagementScreen {
    private static final String title = "## 노선 관리 화면\n";

    public static class SingletonHolder {
        private static final LineManagementScreen instance = new LineManagementScreen();
    }

    public static LineManagementScreen getInstance() {
        return LineManagementScreen.SingletonHolder.instance;
    }

    public ScreenType getNextScreen(LineCommand lineCommand) {
        return ScreenType.MAIN;
    }

    @Override
    public String toString() {
        String content = Arrays.stream(LineCommand.values())
                .map(command -> command.toString())
                .collect(Collectors.joining());

        return title + content;
    }
}

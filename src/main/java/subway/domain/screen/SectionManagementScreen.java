package subway.domain.screen;

import subway.domain.command.SectionCommand;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SectionManagementScreen {
    private static final String title = "## 구간 관리 화면\n";

    public static class SingletonHolder {
        private static final SectionManagementScreen instance = new SectionManagementScreen();
    }

    public static SectionManagementScreen getInstance() {
        return SectionManagementScreen.SingletonHolder.instance;
    }

    public ScreenType getNextScreen(SectionCommand sectionCommand) {
        return ScreenType.MAIN;
    }

    @Override
    public String toString() {
        String content = Arrays.stream(SectionCommand.values())
                .map(command -> command.toString())
                .collect(Collectors.joining());

        return title + content;
    }
}

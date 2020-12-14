package subway.userinterface;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.exception.IllegalCommandException;

import java.util.Arrays;
import java.util.Objects;

public class MainView extends View {
    private static final MainView instance;

    static MainView getInstance() {
        return instance;
    }

    static {
        instance = new MainView();
    }

    private MainView() {
    }

    @Override
    public void printGuidance() {
        System.out.println(
                "## 메인 화면\n" +
                        "1. 역 관리\n" +
                        "2. 노선 관리\n" +
                        "3. 구간 관리\n" +
                        "4. 지하철 노선도 출력\n" +
                        "Q. 종료");
    }

    @Override
    void validateCommand(String command) {
        Arrays.stream(Command.values())
                .filter(mainViewCommand -> Objects.equals(mainViewCommand.value, command))
                .findAny()
                .orElseThrow(IllegalCommandException::new);
    }

    @Override
    void executeCommand(String command) {
        if (Command.GO_STATION_MANAGEMENT.value.equals(command)) {
            UserInterface.setView(StationManagementView.getInstance());
        }
        if (Command.GO_LINE_MANAGEMENT.value.equals(command)) {
            UserInterface.setView(LineManagementView.getInstance());
        }
        if (Command.GO_SECTION_MANAGEMENT.value.equals(command)) {
            UserInterface.setView(SectionManagementView.getInstance());
        }
        if (Command.PRINT_ALL_LINE.value.equals(command)) {
            printAllLine();
        }
        if (Command.APPLICATION_SHUT_DOWN.value.equals(command)) {
            UserInterface.applicationShutDown();
        }
    }

    @Override
    void finish() {

    }

    private void printAllLine() {
        StringBuilder outputBuilder = new StringBuilder();

        LineRepository.lines().forEach(line -> outputBuilder
                .append(line)
                .append("[INFO] ---\n")
                .append(getStringAllStation(line))
                .append("\n"));

        System.out.print(outputBuilder.toString());
    }

    private String getStringAllStation(Line line) {
        StringBuilder stringBuilder = new StringBuilder();

        line.getStations().forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    private enum Command {
        GO_STATION_MANAGEMENT("1"),
        GO_LINE_MANAGEMENT("2"),
        GO_SECTION_MANAGEMENT("3"),
        PRINT_ALL_LINE("4"),
        APPLICATION_SHUT_DOWN("Q");

        private final String value;

        Command(String value) {
            this.value = value;
        }
    }
}

package subway.userinterface;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.exception.IllegalCommandException;

public class MainView implements View {
    private static final MainView instance;

    private static final String GO_STATION_MANAGEMENT = "1";
    private static final String GO_LINE_MANAGEMENT = "2";
    private static final String GO_SECTION_MANAGEMENT = "3";
    private static final String PRINT_ALL_LINE = "4";
    private static final String APPLICATION_SHUT_DOWN = "Q";

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
                        "Q. 종료\n");
    }

    @Override
    public void processCommand(String command) {
        if (command.equals(GO_STATION_MANAGEMENT)) {
            UserInterface.setView(StationManagementView.getInstance());
            return;
        }

        if (command.equals(GO_LINE_MANAGEMENT)) {
            UserInterface.setView(LineManagementView.getInstance());
            return;
        }

        if (command.equals(GO_SECTION_MANAGEMENT)) {
            UserInterface.setView(SectionManagementView.getInstance());
            return;
        }

        if (command.equals(PRINT_ALL_LINE)) {
            printAllLine();
            return;
        }

        if (command.equals(APPLICATION_SHUT_DOWN)) {
            UserInterface.applicationShutDown();
            return;
        }

        throw new IllegalCommandException();
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
}

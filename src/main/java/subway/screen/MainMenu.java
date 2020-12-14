package subway.screen;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.LineRepository;

enum MainMenu {
    STATION_MANAGE("1") {
        @Override void executeMenu(Scanner scanner) { new StationScreen().startProcess(scanner); }
    },
    LINE_MANAGE("2") {
        @Override void executeMenu(Scanner scanner) { new StationScreen().startProcess(scanner); }
    },
    SECTION_MANAGE("3") {
        @Override void executeMenu(Scanner scanner) { new SectionScreen().startProcess(scanner); }
    },
    SUBWAY_MAP("4") {
        @Override void executeMenu(Scanner scanner) { LineRepository.printSubwayMap(); }
    },
    QUIT("Q") {
        @Override void executeMenu(Scanner scanner) { }
    };

    abstract void executeMenu(Scanner scanner);
    private final String symbol;
    private static final String screen = "\n## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";

    MainMenu(String symbol) { this.symbol = symbol; }
    public String getSymbol() { return symbol; }
    public static String getScreen() { return screen; }

    public static void executeMenuByInput(String input, Scanner scanner) {
        Arrays.stream(MainMenu.values())
            .filter(menu -> menu.getSymbol().equals(input))
            .findAny().get().executeMenu(scanner);
    }
}

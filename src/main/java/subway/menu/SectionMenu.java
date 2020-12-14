package subway.menu;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.message.SectionMessage;

public enum SectionMenu implements SectionMessage {
    ADD("1") {
        @Override
        void execute(Scanner scanner) {
            System.out.println(MESSAGE_ADD_SECTION_INPUT_LINE_NAME);
            String lineName = scanner.nextLine();
            Line line = LineRepository.getLine(lineName); // 노선 얻기

            System.out.println(MESSAGE_ADD_SECTION_INPUT_STATION_NAME);
            String stationName = scanner.nextLine();
            System.out.println(MESSAGE_ADD_SECTION_INPUT_STATION_INDEX);
            String stationIndex = scanner.nextLine();
            line.addStation(stationName, stationIndex); // 구간 추가

            System.out.println(MESSAGE_SECTION_ADDED);
        }
    },
    DELETE("2") {
        @Override
        void execute(Scanner scanner) {
            System.out.println(MESSAGE_DELETE_SECTION_INPUT_LINE_NAME);
            String lineName = scanner.nextLine();
            Line line = LineRepository.getLine(lineName); // 노선 얻기

            System.out.println(MESSAGE_DELETE_SECTION_INPUT_STATION_NAME);
            String stationName = scanner.nextLine();
            line.deleteStation(stationName); // 노선에서 구간 삭제

            System.out.println(MESSAGE_SECTION_DELETED);
        }
    },
    BACK("B") {
        @Override
        void execute(Scanner scanner) { }
    };

    private final String symbol;
    private static final String screen = "\n## 구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\nB. 돌아가기";

    SectionMenu (String symbol) { this.symbol = symbol; }

    public String getSymbol() { return symbol; }

    public static String getScreen() { return screen; }

    abstract void execute(Scanner scanner);

    public static void executeMenuByInput(Scanner scanner, String input) {
        Arrays.stream(SectionMenu.values())
            .filter(menu -> menu.getSymbol().equals(input))
            .findAny()
            .get()
            .execute(scanner);
    }
}

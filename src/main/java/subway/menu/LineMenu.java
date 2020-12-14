package subway.menu;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.LineRepository;
import subway.message.LineMessage;

public enum LineMenu implements LineMessage {
    ADD("1") {
        @Override
        void execute(Scanner scanner) {
            System.out.println(MESSAGE_INPUT_LINE_NAME_TO_ADD);
            String lineName = scanner.nextLine();
            LineRepository.validateLineName(lineName);

            System.out.println(MESSAGE_INPUT_UP_END_STATION_OF_LINE_TO_ADD);
            String upEndStation = scanner.nextLine();

            System.out.println(MESSAGE_INPUT_DOWN_END_STATION_OF_LINE_TO_ADD);
            String downEndStation = scanner.nextLine();
            LineRepository.validateEndStationNames(upEndStation, downEndStation);
            LineRepository.initializeLine(lineName, upEndStation, downEndStation);

            System.out.println(MESSAGE_LINE_ADDED);
        }
    },
    DELETE("2") {
        @Override
        void execute(Scanner scanner) {
            System.out.println(MESSAGE_INPUT_LINE_NAME_TO_DELETE);
            String lineName = scanner.nextLine();
            LineRepository.deleteLineByName(lineName);

            System.out.println(MESSAGE_LINE_DELETED);
        }
    },
    DISPLAY("3") {
        @Override
        void execute(Scanner scanner) {
            System.out.println(MESSAGE_LINE_LIST);
            LineRepository.displayAllLines();
        }
    },
    BACK("B") {
        @Override
        void execute(Scanner scanner) { }
    };

    private final String symbol;
    private static final String screen = "\n## 노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기";

    LineMenu (String symbol) { this.symbol = symbol; }

    public String getSymbol() { return symbol; }

    public static String getScreen() { return screen; }

    abstract void execute(Scanner scanner);

    public static void executeMenuByInput(Scanner scanner, String input) {
        Arrays.stream(LineMenu.values())
            .filter(menu -> menu.getSymbol().equals(input))
            .findAny()
            .get()
            .execute(scanner);
    }
}

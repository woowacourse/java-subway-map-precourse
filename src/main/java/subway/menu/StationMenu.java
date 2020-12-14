package subway.menu;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.StationRepository;
import subway.message.StationMessage;

public enum StationMenu implements StationMessage {
    ADD("1") {
        @Override
        void execute(Scanner scanner) {
            System.out.println(MESSAGE_ADD_STATION_INPUT_STATION_NAME);
            String stationName = scanner.nextLine();
            StationRepository.addStation(stationName);

            System.out.println(MESSAGE_STATION_ADDED);
        }
    },
    DELETE("2") {
        @Override
        void execute(Scanner scanner) {
            System.out.println(MESSAGE_DELETE_STATION_INPUT_STATION_NAME);
            String stationName = scanner.nextLine();
            StationRepository.deleteStation(stationName);

            System.out.println(MESSAGE_STATION_DELETED);
        }
    },
    DISPLAY("3") {
        @Override
        void execute(Scanner scanner) {
            System.out.println(MESSAGE_STATION_LIST);
            StationRepository.displayAllStations();
        }
    },
    BACK("B") {
        @Override
        void execute(Scanner scanner) { }
    };

    private final String symbol;
    private static final String screen = "\n## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기";

    StationMenu (String symbol) { this.symbol = symbol; }

    public String getSymbol() { return symbol; }

    public static String getScreen() { return screen; }

    abstract void execute(Scanner scanner);

    public static void executeMenuByInput(Scanner scanner, String input) {
        Arrays.stream(StationMenu.values())
            .filter(menu -> menu.getSymbol().equals(input))
            .findAny()
            .get()
            .execute(scanner);
    }

}

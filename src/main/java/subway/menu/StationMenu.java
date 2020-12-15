package subway.menu;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.util.StationValidator;

import java.util.Scanner;

public class StationMenu {
    private static final String MENU_TITLE = "## 역 관리 화면";
    private static final String MENU1 = "1. 역 등록";
    private static final String MENU2 = "2. 역 삭제";
    private static final String MENU3 = "3. 역 조회";
    private static final String BACK = "B. 돌아가기";
    private static final String CHOICE_MESSAGE = "## 원하는 기능을 선택하세요.";

    private Scanner scanner;

    public StationMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startStationMenu() {
        String input;
        while (true) {
            printStationMenu();
            input = this.scanner.nextLine();
            //TODO 함수 분리하기
            if (input.equals("1")) {
                System.out.println("## 등록할 역 이름을 입력하세요.");
                String stationName = scanner.nextLine();
                if (StationValidator.checkValidStationName(stationName)) {
                    StationRepository.addStation(new Station(stationName));
                    System.out.println("[ INFO ] 지하철 역이 등록되었습니다.");
                }
            }
            if (input.equals("2")) {
                System.out.println("## 삭제할 역 이름을 입력하세요.");
                String stationName = scanner.nextLine();
                if (StationRepository.deleteStation(stationName)) {
                    System.out.println("[ INFO ] 지하철 역이 삭제되었습니다.");
                }
            }
            if (input.equals("3")) {
            }
            if (input.equals("B")) {
                break;
            }
        }
    }

    public void printStationMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(MENU_TITLE).append("\n")
                .append(MENU1).append("\n")
                .append(MENU2).append("\n")
                .append(MENU3).append("\n")
                .append(BACK).append("\n")
                .append(CHOICE_MESSAGE);
        System.out.println(sb);
    }
}

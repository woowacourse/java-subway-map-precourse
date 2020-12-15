package subway.menu;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.util.StationValidator;

import java.util.Scanner;

public class LineMenu {
    private static final String MENU_TITLE = "## 노선 관리 화면";
    private static final String MENU1 = "1. 노선 등록";
    private static final String MENU2 = "2. 노선 삭제";
    private static final String MENU3 = "3. 노선 조회";
    private static final String BACK = "B. 돌아가기";
    private static final String CHOICE_MESSAGE = "## 원하는 기능을 선택하세요.";

    private Scanner scanner;

    public LineMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startLineMenu() {
        String input;
        while (true) {
            printLineMenu();
            input = scanner.nextLine();
            System.out.println();
            //TODO 함수 분리하기
            if (input.equals("1")) {
            }
            if (input.equals("2")) {
            }
            if (input.equals("3")) {
            }
            if (input.equals("B")) {
                break;
            }
        }

    }

    //TODO 출력 기능을 다른곳에 모으기
    public void printLineMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(MENU_TITLE).append("\n")
                .append(MENU1).append("\n")
                .append(MENU2).append("\n")
                .append(MENU3).append("\n")
                .append(BACK).append("\n\n")
                .append(CHOICE_MESSAGE);
        System.out.println(sb);
    }
}

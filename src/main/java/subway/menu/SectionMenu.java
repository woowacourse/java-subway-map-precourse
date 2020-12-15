package subway.menu;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.util.LineValidator;
import subway.util.SectionValidator;
import subway.util.StationValidator;

import java.util.Objects;
import java.util.Scanner;

public class SectionMenu {
    private static final String MENU_TITLE = "## 구간 관리 화면";
    private static final String MENU1 = "1. 구간 등록";
    private static final String MENU2 = "2. 구간 삭제";
    private static final String BACK = "B. 돌아가기";
    private static final String CHOICE_MESSAGE = "## 원하는 기능을 선택하세요.";

    private Scanner scanner;

    public SectionMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startSectionMenu() {
        while (true) {
            printSectionMenu();
            String input = scanner.nextLine();
            if (input.equals("1")) {
                System.out.println("\n## 노선을 입력하세요.");
                String lineName = scanner.nextLine();
                if (LineValidator.checkDuplicateName(lineName)) {
                    System.out.println("\n## 역 이름을 입력하세요.");
                    String stationName = scanner.nextLine();
                    if (StationValidator.checkDuplicateName(stationName)) {
                        System.out.println("\n## 순서를 입력하세요.");
                        String index = scanner.nextLine();
                        if (SectionValidator.checkValidIndex(index, lineName)) {
                            Objects.requireNonNull(LineRepository.findLineByName(lineName)).add(index, stationName);
                        }
                    }
                }
            }
            if (input.equals("2")) {
            }
            if (input.equals("B")) {
                break;
            }
        }
    }

    private void printSectionMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(MENU_TITLE).append("\n")
                .append(MENU1).append("\n")
                .append(MENU2).append("\n")
                .append(BACK).append("\n\n")
                .append(CHOICE_MESSAGE);
        System.out.println(sb);
    }
}

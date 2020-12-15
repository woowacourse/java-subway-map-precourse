package subway.menu;

import subway.domain.Line;
import subway.service.LineService;
import subway.util.LineValidator;
import subway.util.StationValidator;

import java.util.List;
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
        selectLineMenu();
    }

    public void selectLineMenu() {
        while (true) {
            printLineMenu();
            String input = scanner.nextLine();
            lineMenu(input);
            if (input.equals("B")) {
                break;
            }
            System.out.println();
        }
    }

    private void lineMenu(String input) {
        if (input.equals("1")) {
            addLineMenu();
        }
        if (input.equals("2")) {
            deleteLineMenu();
        }
        if (input.equals("3")) {
            printLineList();
        }
    }

    private void addLineMenu() {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        String lineName = scanner.nextLine();
        addLineName(lineName);
    }

    private void addLineName(String lineName) {
        if (LineValidator.checkValidLineName(lineName)) {
            addUpLineLastStop(lineName);
        }
    }

    private void addUpLineLastStop(String lineName) {
        System.out.println("\n## 등록할 상행 종점역 이름을 입력하세요.");
        String upLineLastStop = scanner.nextLine();
        if (StationValidator.haveStationName(upLineLastStop)) {
            addDownLineLastStop(lineName, upLineLastStop);
        }
    }

    private void addDownLineLastStop(String lineName, String upLineLastStop) {
        System.out.println("\n## 등록할 하행 종점역 이름을 입력하세요.");
        String downLineLastStop = scanner.nextLine();
        if (LineValidator.checkValidDownLastStop(upLineLastStop, downLineLastStop)) {
            LineService.addLine(lineName, upLineLastStop, downLineLastStop);
            System.out.println("\n[ INFO ] 지하철 노선이 등록되었습니다.");
        }
    }

    private void deleteLineMenu(){
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        String lineName = scanner.nextLine();
        if (LineValidator.haveLineName(lineName)) {
            LineService.deleteLine(lineName);
            System.out.println("[ INFO ] 지하철 노선이 삭제되었습니다.");
        }
    }

    private void printLineList() {
        System.out.println("## 노선 목록");
        List<Line> lines = LineService.getLineList();
        if (lines.size() == 0) {
            System.out.println("존재하는 노선이 없습니다.");
            return;
        }
        for (Line line : lines) {
            System.out.println("[ INFO ] " + line.getName());
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

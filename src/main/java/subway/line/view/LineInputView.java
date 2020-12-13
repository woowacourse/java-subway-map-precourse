package subway.line.view;

import subway.line.validation.CheckRegisteredLine;

import java.util.Scanner;

public class LineInputView {
    private static final String ENTER_NEW_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    private static final String ENTER_START_STATION_NAME = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String ENTER_END_STATION_NAME = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String ENTER_DELETE_LINE_NAME = "## 삭제할 노선 이름을 입력하세요.";
    private static final String ENTER_LINE_NAME = "## 노선을 입력하세요.";
    private static final String ENTER_SECTION_NUMBER = "## 순서를 입력하세요.";

    private Scanner scanner;

    public LineInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String newLineName() {
        System.out.println(ENTER_NEW_LINE_NAME);
        return scanner.next();
    }

    public String startStationName() {
        System.out.println(ENTER_START_STATION_NAME);
        return scanner.next();
    }

    public String endStationName() {
        System.out.println(ENTER_END_STATION_NAME);
        return scanner.next();
    }

    public String deleteLineName() {
        System.out.println(ENTER_DELETE_LINE_NAME);
        return scanner.next();
    }

    public String lineName() {
        System.out.println(ENTER_LINE_NAME);
        String lineName = scanner.next();
        CheckRegisteredLine.validation(lineName);
        return lineName;
    }

    public int sectionNumber() {
        System.out.println(ENTER_SECTION_NUMBER);
        return scanner.nextInt();
    }
}

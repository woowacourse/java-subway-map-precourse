package subway.line.view;

import java.util.Scanner;

public class LineInputView {
    private static final String ENTER_NEW_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    private static final String ENTER_START_STATION_NAME = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String ENTER_END_STATION_NAME = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";

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
}

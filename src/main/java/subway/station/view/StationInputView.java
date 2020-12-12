package subway.station.view;

import java.util.Scanner;

public class StationInputView {
    private static final String ENTER_NEW_STATION = "## 등록할 역 이름을 입력하세요.";
    private static final String BLANK = " ";
    private static final String EMPTY = "";

    private Scanner scanner;

    public StationInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String addStation() {
        System.out.println(ENTER_NEW_STATION);
        String station = scanner.next();
        return station.replaceAll(BLANK, EMPTY);
    }
}

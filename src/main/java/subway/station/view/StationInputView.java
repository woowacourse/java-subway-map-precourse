package subway.station.view;

import java.util.Scanner;

public class StationInputView {
    private static final String ENTER_NEW_STATION = "## 등록할 역 이름을 입력하세요.";
    private static final String ENTER_DELETE_STATION = "## 삭제할 역 이름을 입력하세요.";
    private static final String ENTER_REGISTERED_STATION = "## 역이름을 입력하세요.";
    private static final String ENTER_DELETE_SECTION_STATION = "## 삭제할 구간의 역을 입력하세요.";
    private static final String BLANK = " ";
    private static final String EMPTY = "";

    private Scanner scanner;

    public StationInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String addStation() {
        System.out.println(ENTER_NEW_STATION);
        return enterStationName();
    }

    public String deleteStation() {
        System.out.println(ENTER_DELETE_STATION);
        return enterStationName();
    }

    public String stationName() {
        System.out.println(ENTER_REGISTERED_STATION);
        return enterStationName();
    }

    public String stationSectionName() {
        System.out.println(ENTER_DELETE_SECTION_STATION);
        return enterStationName();
    }

    private String enterStationName() {
        String station = scanner.next();
        return station.replaceAll(BLANK, EMPTY);
    }
}

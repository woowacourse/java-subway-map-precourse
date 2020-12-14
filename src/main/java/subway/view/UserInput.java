package subway.view;

import java.util.Scanner;

public class UserInput extends Display{
    private static final String REQUEST_SELECT_MENU_MESSAGE = "원하는 기능을 선택하세요.";
    private static final String REQUEST_SAVE_STATION_MESSAGE = "등록할 역 이름을 입력하세요.";
    private static final String REQUEST_DELETE_STATION_MESSAGE = "삭제할 역 이름을 입력하세요.";
    private static final String REQUEST_SAVE_LINE_MESSAGE = "등록할 노선 이름을 입력하세요.";
    private static final String REQUEST_START_STATION_MESSAGE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String REQUEST_END_STATION_MESSAGE = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String REQUEST_DELETE_LINE_MESSAGE = "삭제할 노선 이름을 입력하세요.";
    private static final String REQUEST_LINE_NAME_FOR_INSERT_MESSAGE = "노선을 입력하세요.";
    private static final String REQUEST_LINE_NAME_FOR_DELETE_MESSAGE = "삭제할 구간의 노선을 입력하세요.";
    private static final String REQUEST_STATION_NAME_FOR_INSERT_MESSAGE = "역이름을 입력하세요.";
    private static final String REQUEST_STATION_NAME_FOR_DELETE_MESSAGE = "삭제할 구간의 역을 입력하세요.";
    private static final String REQUEST_STATION_POSITION_MESSAGE = "순서를 입력하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String getMenu() {
        printNotice(REQUEST_SELECT_MENU_MESSAGE);
        return scanner.nextLine().toUpperCase(); // 소문자 입력 예외처리
    }

    public static String getSaveStationName(){
        printNotice(REQUEST_SAVE_STATION_MESSAGE);
        return scanner.nextLine();
    }

    public static String getDeleteStationName() {
        printNotice(REQUEST_DELETE_STATION_MESSAGE);
        return scanner.nextLine();
    }

    public static String getSaveLineName() {
        printNotice(REQUEST_SAVE_LINE_MESSAGE);
        return scanner.nextLine();
    }

    public static String getDeleteLineName() {
        printNotice(REQUEST_DELETE_LINE_MESSAGE);
        return scanner.nextLine();
    }

    public static String getStartStationName() {
        printNotice(REQUEST_START_STATION_MESSAGE);
        return scanner.nextLine();
    }

    public static String getEndStationName() {
        printNotice(REQUEST_END_STATION_MESSAGE);
        return scanner.nextLine();
    }

    public static String getLineNameForInsert() {
        printNotice(REQUEST_LINE_NAME_FOR_INSERT_MESSAGE);
        return scanner.nextLine();
    }

    public static String getLineNameForDelete() {
        printNotice(REQUEST_LINE_NAME_FOR_DELETE_MESSAGE);
        return scanner.nextLine();
    }

    public static String getStationNameForInsert() {
        printNotice(REQUEST_STATION_NAME_FOR_INSERT_MESSAGE);
        return scanner.nextLine();
    }

    public static String getStationNameForDelete() {
        printNotice(REQUEST_STATION_NAME_FOR_DELETE_MESSAGE);
        return scanner.nextLine();
    }

    public static String getStationPosition() {
        printNotice(REQUEST_STATION_POSITION_MESSAGE);
        return scanner.nextLine();
    }
}

package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String SELECT_MENU_MESSAGE = "## 원하는 기능을 선택사헤요.";
    private static final String REGISTER_STATION_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String DELETE_STATION_MESSAGE = "## 삭제할 역 이름을 입력하세요."; // 역 관련

    private static final String REGISTER_LINE_MESSAGE = "## 등록할 노선의 이름을 입력하세요.";
    private static final String UPSTREAM_STATION_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String DOWNSTREAM_STATION_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String DELETE_LINE_MESSAGE = "## 삭제할 노선 이름을 입력핫에ㅛ."; // 노선 관련

    private static final String REGISTER_SECTION_LINE_MESSAGE = "## 노선을 입력하세요.";
    private static final String REGISTER_SECTION_STATION_MESSAGE = "## 역이름을 입력하세요.";
    private static final String REGISTER_SECTION_ORDER_MESSAGE = "## 순서를 입력하세요.";
    private static final String DELETE_SECTION_LINE_MESSAGE = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String DELETE_SECTION_STATION_MESSAGE = "## 삭제할 구간의 역을 입력하세요."; // 구간 관련
    private static final Scanner scanner = new Scanner(System.in);

    public static String getMenu() {
        System.out.println("\n" + SELECT_MENU_MESSAGE);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public static String registerStationName() {
        System.out.println(REGISTER_STATION_MESSAGE);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public static String deleteStationName() {
        System.out.println(DELETE_STATION_MESSAGE);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public static String registerLineName() {
        System.out.println(REGISTER_LINE_MESSAGE);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public static String deleteLineName() {
        System.out.println(DELETE_LINE_MESSAGE);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public static String upstreamStationName() {
        System.out.println(UPSTREAM_STATION_MESSAGE);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public static String downstreamStationName() {
        System.out.println(DOWNSTREAM_STATION_MESSAGE);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public static String registerSectionLine() {
        System.out.println(REGISTER_SECTION_LINE_MESSAGE);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public static String registerSectionStation() {
        System.out.println(REGISTER_SECTION_STATION_MESSAGE);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public static String registerSectionOrder() {
        System.out.println(REGISTER_SECTION_ORDER_MESSAGE);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public static String deleteSectionLine() {
        System.out.println(DELETE_SECTION_LINE_MESSAGE);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public static String deleteSectionStation() {
        System.out.println(DELETE_SECTION_STATION_MESSAGE);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }
}

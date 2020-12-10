package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String SELECT_MENU="## 원하는 기능을 선택하세요.";
    private static final String INSERT_STATION_TEXT="## 등록할 역 이름을 입력하세요.";
    private static final String INSERT_LINE_TEXT="## 등록할 노선 이름을 입력하세요.";
    private static final String UPWARD_LINE_TEXT="## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String DOWN_LINE_TEXT="## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String DELETE_STATION_TEXT="## 삭제할 역 이름을 입력하세요.";
    private static final String DELETE_LINE_TEXT="## 삭제할 노선 이름을 입력하세요.";
    private static final String ORDER_SECTION_TEXT="## 순서를 입력하세요.";
    private static final Scanner scanner=new Scanner(System.in);

    public static String getMenu(){
        System.out.println();
        System.out.println(SELECT_MENU);
        String result=scanner.nextLine();
        System.out.println();
        return result;
    }

    public static String getStationName(){
        System.out.println(INSERT_STATION_TEXT);
        String result=scanner.nextLine();
        System.out.println();
        return result;
    }

    public static String getUpwardStationName(){
        System.out.println(UPWARD_LINE_TEXT);
        String result=scanner.nextLine();
        System.out.println();
        return result;
    }

    public static String getDownStationName(){
        System.out.println(DOWN_LINE_TEXT);
        String result=scanner.nextLine();
        System.out.println();
        return result;
    }

    public static String getLineName(){
        System.out.println(INSERT_LINE_TEXT);
        String result=scanner.nextLine();
        System.out.println();
        return result;
    }

    public static String getDeleteLineName(){
        System.out.println(DELETE_LINE_TEXT);
        String result=scanner.nextLine();
        System.out.println();
        return result;
    }

    public static String getDeleteStationName(){
        System.out.println(DELETE_STATION_TEXT);
        String result=scanner.nextLine();
        System.out.println();
        return result;
    }

    public static String getSectionOrder(){
        System.out.println(ORDER_SECTION_TEXT);
        String result=scanner.nextLine();
        System.out.println();
        return result;
    }
}

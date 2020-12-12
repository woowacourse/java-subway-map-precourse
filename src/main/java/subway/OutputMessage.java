package subway;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class OutputMessage {
    public OutputMessage(){

    }
    private static final String MAIN_DISPLAY_MESSAGE="## 메인 화면";
    private static final String MAIN_MANAGE_STATION="1. 역 관리";
    private static final String MAIN_MANAGE_LINE="2. 노선 관리";
    private static final String MAIN_MANAGE_IN_LINE="3. 구간 관리";
    private static final String MAIN_QUIT="Q. 종료";
    private static final String MENU_BACK="B. 돌아가기";

    private static final String STATION_MANAGE_MESSAGE="## 역 관리 화면";
    private static final String STATION_MANAGE_REGISTRATION="1. 역 등록";
    private static final String STATION_MANAGE_DELETE="2. 역 삭제";
    private static final String STATION_MANAGE_SEARCH="3. 역 조회";

    private static final String LINE_MANAGE_MESSAGE="## 노선 관리 화면";
    private static final String LINE_MANAGE_REGISTRATION="1. 노선 등록";
    private static final String LINE_MANAGE_DELETE="2. 노선 삭제";
    private static final String LINE_MANAGE_SEARCH="3. 노선 조회";

    private static final String IN_LINE_MANAGE_MESSAGE="## 구간 관리 화면";
    private static final String IN_LINE_MANAGE_REGISTRATION="1. 구간 등록";
    private static final String IN_LINE_MANAGE_DELETE="2. 구간 삭제";

    private static final String CHOICE_FUNCTION_MESSAGE="## 원하는 기능을 선택하세요";
    public void mainOutputMessage(){
        System.out.println(MAIN_DISPLAY_MESSAGE);
        System.out.println(MAIN_MANAGE_STATION);
        System.out.println(MAIN_MANAGE_LINE);
        System.out.println(MAIN_MANAGE_IN_LINE);
        System.out.println(MAIN_QUIT);
        System.out.println();
    }
    public int choiceOutputMessage(Scanner scanner){
        System.out.println(CHOICE_FUNCTION_MESSAGE);
        return scanner.nextInt();
    }

}

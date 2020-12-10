/**
 * Application.java
 * 메인 화면에서 기능을 선택할 수 있도록 합니다.
 *
 * @author
 * Kimun Kim, github.com/tributetothemoon
 */

package subway;

import subway.controller.LineManagement;
import subway.controller.StationManagement;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class Application {
    private static final String STATION_MANAGEMENT = "1";
    private static final String LINE_MANAGEMENT = "2";
    private static final String SECTION_MANAGEMENT = "3";
    private static final String SHOW_SUBWAY_LINE = "4";
    private static final String QUIT = "Q";

    private static String menu;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        InputView.setScanner(scanner);
        run();
    }

    private static void run() {
        do{
            OutputView.showMainMenu();
            menu = InputView.getMainMenuSelection(); //무조건 올바른 값이 넘어오도록 설정
            runSelectedMenuFunction();
        }while(!menu.equals(QUIT));
    }

    private static void runSelectedMenuFunction() {
        if (menu.equals(STATION_MANAGEMENT)) {
            StationManagement.run();
        }
        if (menu.equals(LINE_MANAGEMENT)) {
            LineManagement.run();
        }
    }
}

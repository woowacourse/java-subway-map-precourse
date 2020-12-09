package subway.controller;

import java.util.Scanner;
import subway.view.InputView;

/**
 * 지하철 노선도 미션 총괄 클래스
 */
public class Subway {

    public static final String STATION_MANGE_MENU = "1";
    public static final String LINE_MANAGE_MENU = "2";
    public static final String SECTION_MANAGE_MENU = "3";
    public static final String SUBWAY_SECTIONS_MENU = "4";
    public static final String CLOSE = "Q";
    private final InputView inputView;
    private final Management management;

    public Subway(Scanner scanner) {
        inputView = new InputView(scanner);
        management = new Management(scanner);
    }

    public void start() {
        chooseMenu(inputView.showMain());
    }

    private void chooseMenu(String input) {
        if (input.equals(STATION_MANGE_MENU)) {
            management.manageStation(input);
        }
        if (input.equals(LINE_MANAGE_MENU)) {
            management.manageLine();
        }
        if (input.equals(SECTION_MANAGE_MENU)) {
            management.mangeSection();
        }
        if (input.equals(SUBWAY_SECTIONS_MENU)) {

        }
        if (input.equals(CLOSE)) {
            return;
        }
    }


}

package subway.controller;

import java.util.Scanner;
import subway.view.InputView;
import subway.view.OutputView;

/**
 * 지하철 노선도 미션 총괄 클래스
 */
public class Subway {

    public static final String STATION_MANGE_MENU = "1";
    public static final String LINE_MANAGE_MENU = "2";
    public static final String SECTION_MANAGE_MENU = "3";
    public static final String SUBWAY_SECTIONS_MENU = "4";
    public static final String CLOSE = "Q";
    private static final String[] initialLines = {"2호선", "3호선", "신분당선"};
    private static final String[] initialStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역",
        "양재시민의숲역", "매봉역"};
    private final InputView inputView;
    private final Management management;

    public Subway(Scanner scanner) {
        inputView = new InputView(scanner);
        management = new Management(scanner);
    }

    public void start() {
        OutputView.showMainMenu();
        boolean continueSystem = chooseMenu(inputView.inputValue());
        if(continueSystem){
            start();
        }
    }

    private boolean chooseMenu(String input) {
        if (input.equals(STATION_MANGE_MENU)) {
            management.manageStation();
        }
        if (input.equals(LINE_MANAGE_MENU)) {
            management.manageLine();
        }
        if (input.equals(SECTION_MANAGE_MENU)) {
            management.mangeSection();
        }
        if (input.equals(SUBWAY_SECTIONS_MENU)) {
            OutputView.showSubwayLineMap();
        }
        if (input.equals(CLOSE)) {
            return false;
        }
        return true;
    }


}

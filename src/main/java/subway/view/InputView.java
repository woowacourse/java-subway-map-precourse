package subway.view;

import java.util.Scanner;
import subway.exception.SubwayCustomException;
import subway.utils.ValidateUtils;

/**
 * 입력값을 받는 클래스
 */
public class InputView {

    private static final String MENU_PREFIX = "## ";
    private static final String MAIN_MENU_MESSAGE = "메인화면 \n"
        + "1. 역 관리 \n"
        + "2. 노선 관리 \n"
        + "3. 구간 관리 \n"
        + "4. 지하철 노선도 출력 \n"
        + "Q. 종료\n";
    private static final String STATION = "역";
    private static final String LINE = "노선";
    private static final String LINE_OR_STATION_MENU_MESSAGE = "%s 관리 화면 \n"
        + "1. %s 등록 \n"
        + "2. %s 삭제 \n"
        + "3. %s 조회 \n"
        + "B. 돌아가기 \n";
    private static final String MENU_CATEGORY_CHOICE_MESSAGE = "원하는 기능을 선택하세요.";
    private static final String INPUT_SECTION_NAME_MESSAGE = "역이름을 입력하세요.";
    private static final String INPUT_SECTION_POSITION_MESSAGE = "순서를 입력하세요.";
    private static final String INPUT_SECTION_LINE_MESSAGE = "노선을 입력하세요.";
    private static final String REMOVE_SECTION_LINE_MESSAGE = "삭제할 구간의 노선을 입력하세요.";
    private static final String REMOVE_SECTION_NAME_MESSAGE = "삭제할 구간의 역을 입력하세요.";
    private static final String INPUT_LINE_NAME_MESSAGE = "등록할 노선의 이름을 입력하세요.";
    private static final String INPUT_STATION_NAME_MESSAGE = "등록할 역 이름을 입력하세요.";
    private static final String REMOVE_STATION_NAME_MESSAGE = "삭제할 역 이름을 입력하세요.";
    private static final String INPUT_LINE_START_STATION_NAME_MESSAGE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_LINE_END_STATION_NAME_MESSAGE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private final Scanner scanner;
    private final ValidateUtils validateUtils;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
        validateUtils = new ValidateUtils();
    }

    public String showMain() {
        System.out.println(MENU_PREFIX + MAIN_MENU_MESSAGE);
        return chooseCategory();
    }

    public String chooseCategory() {
        System.out.println(MENU_PREFIX + MENU_CATEGORY_CHOICE_MESSAGE);
        try {
            String input = scanner.nextLine();
            //validateUtils.isValid(input); // 메뉴에 있는 카테고리인지 확인
            return input.toUpperCase();
        } catch (SubwayCustomException exception) {
            System.out.println(exception.getMessage());
            return chooseCategory();
        }
    }

    public String chooseLineOrStationMenu(String input) {
        if (input.equals("1")) {
            System.out.printf(MENU_PREFIX + LINE_OR_STATION_MENU_MESSAGE, LINE, LINE, LINE, LINE);
            return chooseCategory();
        }
        if (input.equals("2")) {
            System.out.printf(MENU_PREFIX + LINE_OR_STATION_MENU_MESSAGE, STATION, STATION, STATION,
                STATION);
            return chooseCategory();
        }
        return null;
    }

    public String insertNewStation(){
        System.out.println(INPUT_STATION_NAME_MESSAGE);
        return scanner.nextLine();
    }
}

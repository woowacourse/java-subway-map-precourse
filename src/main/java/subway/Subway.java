package subway;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Subway {
    private static final String MAIN_MENU = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n" +
                                                    "4. 지하철 노선도 출력\nQ. 종료\n";
    private static final String WRONG_STATE_TRY_AGAIN = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String ONE = "1";
    private static final String TOW = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String APPLICATION_QUIT = "Q";

    private Scanner scanner;
    private Map<String, Object> menus = new HashMap<>();

    public Subway(Scanner scanner) {
        this.scanner = scanner;
        initSubway();
        StationRepository.init();
        LineRepository.init();
    }

    public String selectState() {
        System.out.println(MAIN_MENU);
        String menu = scanner.next();
        try {
            if (!menus.containsKey(menu)) {
                throw new IllegalArgumentException(WRONG_STATE_TRY_AGAIN);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectState();
        }
        return menu;
    }

    private void initSubway() {
        menus.put(ONE, new InputStationManager(scanner));
        menus.put(TOW, "2");
        menus.put(THREE, "3");
        menus.put(FOUR, "4");
        menus.put(APPLICATION_QUIT, "Q");
    }

    public Object getMenus(String name) {
        return menus.get(name);
    }

}
package subway.view.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainMenu extends Menu {
    private static final String VIEW_NAME = "메인 화면";
    private static final String STATION_MANAGEMENT = "역 관리";
    private static final String LINE_MANAGEMENT = "노선 관리";
    private static final String SECTION_MANAGEMENT = "구간 관리";
    private static final String SUBWAY_MAP = "지하철 노선도 출력";
    private static final String ESCAPE = "종료";
    private static final String ESCAPE_VALUE = "Q";
    private static final int MENU_START_INDEX = 1;

    private static MainMenu instance;

    private MainMenu() {
        viewName = VIEW_NAME;
        List<String> descriptions = new ArrayList<>(Arrays.asList(
                STATION_MANAGEMENT, LINE_MANAGEMENT, SECTION_MANAGEMENT, SUBWAY_MAP, ESCAPE
        ));
        Iterator<String> description = descriptions.iterator();
        selections = IntStream.range(MENU_START_INDEX, descriptions.size())
                .mapToObj(Integer::toString)
                .map(i -> new Selection(i, description.next()))
                .collect(Collectors.toList());
        selections.add(new Selection(ESCAPE_VALUE, ESCAPE));
    }

    public static MainMenu getInstance() {
        if (instance == null) {
            instance = new MainMenu();
        }
        return instance;
    }

}

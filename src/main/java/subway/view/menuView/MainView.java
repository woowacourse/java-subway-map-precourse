package subway.view.menuView;

import subway.menuType.MainMenuType;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainView extends MenuView<MainMenuType> {
    private static final String VIEW_NAME = "메인 화면";
    private static final String STATION_MANAGEMENT = "역 관리";
    private static final String LINE_MANAGEMENT = "노선 관리";
    private static final String SECTION_MANAGEMENT = "구간 관리";
    private static final String SUBWAY_MAP = "지하철 노선도 출력";
    private static final String ESCAPE = "종료";
    private static final String ESCAPE_VALUE = "Q";

    private static MainView instance;

    private MainView() {
        viewName = VIEW_NAME;
        List<String> descriptions = new ArrayList<>(Arrays.asList(
                STATION_MANAGEMENT, LINE_MANAGEMENT, SECTION_MANAGEMENT, SUBWAY_MAP, ESCAPE
        ));
        List<String> menuIndexs = new ArrayList<>(IntStream.range(MENU_START_INDEX, descriptions.size())
                .mapToObj(Integer::toString)
                .collect(Collectors.toList()));
        menuIndexs.add(ESCAPE_VALUE);
        initializeSelections(menuIndexs, descriptions);

        initializeHashMapToFunctionType(this.selections.toList(), Arrays.asList(MainMenuType.values()));
    }

    public static MainView getInstance() {
        if (instance == null) {
            instance = new MainView();
        }
        return instance;
    }

}

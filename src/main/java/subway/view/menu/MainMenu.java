package subway.view.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MainMenu extends Menu {
    private static final String STATION_MANAGEMENT = "역 관리";
    private static final String LINE_MANAGEMENT = "노선 관리";
    private static final String SECTION_MANAGEMENT = "구간 관리";
    private static final String SUBWAY_MAP = "지하철 노선도 출력";
    private static final String QUIT = "종료";
    private static final int MENU_START_INDEX = 1;
    private static final int MENU_LENGTH = 4;

    private static MainMenu instance;

    private MainMenu() {
        menu = new ArrayList<>(Arrays.asList(
                STATION_MANAGEMENT, LINE_MANAGEMENT, SECTION_MANAGEMENT, SUBWAY_MAP, QUIT
        ));
        IntStream.rangeClosed(MENU_START_INDEX, MENU_LENGTH)
                .mapToObj(Integer::toString)
                .forEach(menuSelections::add);
        menuSelections.add("Q");
    }

    public static MainMenu getInstance() {
        if (instance == null) {
            instance = new MainMenu();
        }
        return instance;
    }

    @Override
    public List<String> getMenu() {
        return menu;
    }

    public List<String> getMenuSelections() {
        return menuSelections;
    }
}

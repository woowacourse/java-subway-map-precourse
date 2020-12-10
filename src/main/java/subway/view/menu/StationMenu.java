package subway.view.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StationMenu extends Menu {
    private static final String CREATE = "역 등록";
    private static final String DELETE = "역 삭제";
    private static final String DISPLAY = "역 조회";
    private static final String BACK = "돌아가기";
    private static final int MENU_START_INDEX = 1;
    private static final int MENU_LENGTH = 3;

    private static StationMenu instance;

    private StationMenu() {
        menu = new ArrayList<>(Arrays.asList(
                CREATE, DELETE, DISPLAY, BACK
        ));
        IntStream.rangeClosed(MENU_START_INDEX, MENU_LENGTH)
                .mapToObj(Integer::toString)
                .forEach(menuSelections::add);
        menuSelections.add("B" );
    }

    public static StationMenu getInstance() {
        if (instance == null) {
            instance = new StationMenu();
        }
        return instance;
    }

    @Override
    public List<String> getMenu() {
        return menu;
    }

    @Override
    public List<String> getMenuSelections() {
        return menuSelections;
    }
}

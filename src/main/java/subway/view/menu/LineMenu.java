package subway.view.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LineMenu extends Menu{
    private static final String VIEW_NAME = "노선 관리 화면";
    private static final String CREATE = "노선 등록";
    private static final String DELETE = "노선 삭제";
    private static final String DISPLAY = "노선 조회";
    private static final String BACK = "돌아가기";
    private static final int MENU_START_INDEX = 1;
    private static final int MENU_LENGTH = 3;

    private static LineMenu instance;

    private LineMenu() {
        menu = new ArrayList<>(Arrays.asList(
                CREATE, DELETE, DISPLAY, BACK
        ));
        IntStream.rangeClosed(MENU_START_INDEX, MENU_LENGTH)
                .mapToObj(Integer::toString)
                .forEach(menuSelections::add);
        menuSelections.add("B");
        viewName = VIEW_NAME;
    }

    public static LineMenu getInstance() {
        if (instance == null) {
            instance = new LineMenu();
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

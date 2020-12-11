package subway.view.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineMenu extends Menu {
    private static final String VIEW_NAME = "노선 관리 화면";
    private static final String CREATE = "노선 등록";
    private static final String DELETE = "노선 삭제";
    private static final String READ = "노선 조회";
    private static final String ESCAPE = "돌아가기";
    private static final String ESCAPE_VALUE = "B";
    private static final int MENU_START_INDEX = 1;

    private static LineMenu instance;

    private LineMenu() {
        viewName = VIEW_NAME;
        List<String> descriptions = new ArrayList<>(Arrays.asList(
                CREATE, DELETE, READ, ESCAPE
        ));
        Iterator<String> description = descriptions.iterator();
        selections = IntStream.range(MENU_START_INDEX, descriptions.size())
                .mapToObj(Integer::toString)
                .map(i -> new Selection(i, description.next()))
                .collect(Collectors.toList());
        selections.add(new Selection(ESCAPE_VALUE, ESCAPE));
    }

    public static LineMenu getInstance() {
        if (instance == null) {
            instance = new LineMenu();
        }
        return instance;
    }
}

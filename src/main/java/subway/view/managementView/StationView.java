package subway.view.managementView;

import subway.view.selection.Selection;
import subway.view.selection.Selections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StationView extends ManagementView {
    private static final String VIEW_NAME = "역 관리 화면";
    private static final String ITEM_PREFIX = "역 ";
    private static final String STATION_REGISTER = "지하철 역이 등록되었습니다.";
    private static final String STATION_DELETE = "지하철 역이 삭제되었습니다.";
    private static final String MENU_CREATE = "역 등록";
    private static final String MENU_DELETE = "역 삭제";
    private static final String MENU_READ = "역 조회";
    private static final String MENU_ESCAPE = "돌아가기";
    private static final String MENU_ESCAPE_VALUE = "B";
    private static final int MENU_START_INDEX = 1;

    private static StationView instance;

    private StationView() {
        selections = new Selections(initializeSelections());
        viewName = VIEW_NAME;
        itemPrefix = ITEM_PREFIX;
        createMessage = STATION_REGISTER;
        deleteMessage = STATION_DELETE;
    }

    private List<Selection> initializeSelections() {
        List<String> descriptions = new ArrayList<>(Arrays.asList(
                MENU_CREATE, MENU_DELETE, MENU_READ, MENU_ESCAPE
        ));
        Iterator<String> description = descriptions.iterator();

        List<Selection> selections = IntStream.range(MENU_START_INDEX, descriptions.size())
                .mapToObj(Integer::toString)
                .map(i -> new Selection(i, description.next()))
                .collect(Collectors.toList());
        selections.add(new Selection(MENU_ESCAPE_VALUE, MENU_ESCAPE));
        return selections;
    }

    public static StationView getInstance() {
        if (instance == null) {
            instance = new StationView();
        }
        return instance;
    }

}

package subway.view.managementView;

import subway.menuType.FunctionType;
import subway.view.selection.Selection;
import subway.view.selection.Selections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StationView extends ManagementView {
    private static final String VIEW_NAME = "역 관리 화면";
    private static final String ITEM_PREFIX = "역 ";
    private static final String STATION_CREATE = "지하철 역이 등록되었습니다.";
    private static final String STATION_DELETE = "지하철 역이 삭제되었습니다.";
    private static final String MENU_CREATE = "역 등록";
    private static final String MENU_DELETE = "역 삭제";
    private static final String MENU_READ = "역 조회";
    private static final String MENU_ESCAPE = "돌아가기";
    private static final String MENU_ESCAPE_VALUE = "B";
    private static final int MENU_START_INDEX = 1;

    private static StationView instance;

    private StationView() {
        initializeSelections();
        initializeHashMapToFunctionType();
        viewName = VIEW_NAME;
        itemPrefix = ITEM_PREFIX;
        createMessage = STATION_CREATE;
        deleteMessage = STATION_DELETE;
    }

    @Override
    protected void initializeHashMapToFunctionType() {
        mapToFunctionType = new HashMap<>();
        Iterator<Selection> selection = selections.toList().iterator();
        for (FunctionType functionType : FunctionType.values()) {
            mapToFunctionType.put(selection.next(), functionType);
        }
    }

    private void initializeSelections() {
        List<String> descriptions = new ArrayList<>(Arrays.asList(
                MENU_CREATE, MENU_DELETE, MENU_READ, MENU_ESCAPE
        ));
        Iterator<String> description = descriptions.iterator();

        List<Selection> selections = new ArrayList<>();
        for (int i = MENU_START_INDEX; i < descriptions.size(); i++) {
            selections.add(new Selection(Integer.toString(i), description.next()));
        }
        selections.add(new Selection(MENU_ESCAPE_VALUE, description.next()));
        this.selections = new Selections(selections);
    }

    public static StationView getInstance() {
        if (instance == null) {
            instance = new StationView();
        }
        return instance;
    }


}

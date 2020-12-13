package subway.view.menuView;

import subway.menuType.FunctionType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StationView extends ManagementView {
    private static final String ITEM_PREFIX = "역 ";
    private static final String STATION_CREATE = "지하철 역이 등록되었습니다.";
    private static final String STATION_DELETE = "지하철 역이 삭제되었습니다.";
    private static final String MENU_CREATE = "역 등록";
    private static final String MENU_DELETE = "역 삭제";
    private static final String MENU_READ = "역 조회";

    private static StationView instance;

    private StationView() {
        initializeSelections();
        initializeHashMapToFunctionType(this.selections.toList(), Arrays.asList(FunctionType.values()));

        viewName = ITEM_PREFIX + VIEW_NAME;
        itemPrefix = ITEM_PREFIX;
        createMessage = STATION_CREATE;
        deleteMessage = STATION_DELETE;
    }

    private void initializeSelections() {
        List<String> descriptions = new ArrayList<>(Arrays.asList(
                MENU_CREATE, MENU_DELETE, MENU_READ, MENU_ESCAPE
        ));

        List<String> menuIndexs = new ArrayList<>();
        for (int i = MENU_START_INDEX; i < descriptions.size(); i++) {
            menuIndexs.add(Integer.toString(i));
        }
        menuIndexs.add(MENU_ESCAPE_VALUE);

        initializeSelections(menuIndexs, descriptions);
    }

    public static StationView getInstance() {
        if (instance == null) {
            instance = new StationView();
        }
        return instance;
    }

}

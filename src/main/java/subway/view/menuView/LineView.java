package subway.view.menuView;

import subway.menuType.ManagementMenuType;
import subway.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineView extends ManagementView {
    private static final String ITEM_PREFIX = "노선 ";
    private static final String LINE_CREATE = "지하철 노선이 등록되었습니다.";
    private static final String LINE_DELETE = "지하철 노선이 삭제되었습니다.";
    private static final String REQUEST_UPLINE_NAME = "노선의 상행 종점역 이름을 입력하세요.";
    private static final String REQUEST_DOWNLINE_NAME = "노선의 하행 종점역 이름을 입력하세요.";
    private static final String MENU_CREATE = "노선 등록";
    private static final String MENU_DELETE = "노선 삭제";
    private static final String MENU_READ = "노선 조회";

    private static LineView instance;

    private LineView() {
        initializeSelections();
        initializeHashMapToMenuType(this.selections.toList(), Arrays.asList(ManagementMenuType.values()));

        viewName = ITEM_PREFIX + VIEW_NAME;
        itemPrefix = ITEM_PREFIX;
        createMessage = LINE_CREATE;
        deleteMessage = LINE_DELETE;
    }

    private void initializeSelections() {
        List<String> descriptions = new ArrayList<>(Arrays.asList(
                MENU_CREATE, MENU_DELETE, MENU_READ, MENU_ESCAPE
        ));

        List<String> menuKeys = new ArrayList<>();
        for (int i = MENU_START_INDEX; i < descriptions.size(); i++) {
            menuKeys.add(Integer.toString(i));
        }
        menuKeys.add(MENU_ESCAPE_KEY);

        initializeSelections(menuKeys, descriptions);
    }

    public static LineView getInstance() {
        if (instance == null) {
            instance = new LineView();
        }
        return instance;
    }

    public String getUplineStationName() {
        return InputView.getStringWithMessage(TO_CREATE_PREFIX + REQUEST_UPLINE_NAME);
    }

    public String getDownlineStationName() {
        return InputView.getStringWithMessage(TO_CREATE_PREFIX + REQUEST_DOWNLINE_NAME);
    }

}

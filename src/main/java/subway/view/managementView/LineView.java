package subway.view.managementView;

import subway.menuType.FunctionType;
import subway.view.InputView;

import java.util.*;

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
        List<String> descriptions = new ArrayList<>(Arrays.asList(
                MENU_CREATE, MENU_DELETE, MENU_READ
        ));
        initializeSelections(descriptions);

        initializeHashMapToFunctionType(selections.toList(), Arrays.asList(FunctionType.values()));

        viewName = ITEM_PREFIX + VIEW_NAME;
        itemPrefix = ITEM_PREFIX;
        createMessage = LINE_CREATE;
        deleteMessage = LINE_DELETE;
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

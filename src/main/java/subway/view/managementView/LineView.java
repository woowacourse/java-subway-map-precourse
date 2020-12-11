package subway.view.managementView;

import subway.menuType.FunctionType;
import subway.view.InputView;
import subway.view.selection.Selection;
import subway.view.selection.Selections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineView extends ManagementView {
    private static final String VIEW_NAME = "노선 관리 화면";
    private static final String ITEM_PREFIX = "노선 ";
    private static final String LINE_CREATE = "지하철 노선이 등록되었습니다.";
    private static final String LINE_DELETE = "지하철 노선이 삭제되었습니다.";
    private static final String TO_REGISTER_PREFIX = "등록할 ";
    private static final String REQUEST_UPLINE_NAME = "노선의 상행 종점역 이름을 입력하세요.";
    private static final String REQUEST_DOWNLINE_NAME = "노선의 하행 종점역 이름을 입력하세요.";
    private static final String MENU_CREATE = "노선 등록";
    private static final String MENU_DELETE = "노선 삭제";
    private static final String MENU_READ = "노선 조회";
    private static final String MENU_ESCAPE = "돌아가기";
    private static final String MENU_ESCAPE_VALUE = "B";

    private static final int MENU_START_INDEX = 1;

    private static LineView instance;

    private LineView() {
        initializeSelections();
        initializeHashMapToFunctionType();
        viewName = VIEW_NAME;
        itemPrefix = ITEM_PREFIX;
        createMessage = LINE_CREATE;
        deleteMessage = LINE_DELETE;
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

    @Override
    protected void initializeHashMapToFunctionType() {
        mapToFunctionType = new HashMap<>();
        Iterator<Selection> selection = selections.toList().iterator();
        for (FunctionType functionType : FunctionType.values()) {
            mapToFunctionType.put(selection.next(), functionType);
        }
    }

    public static LineView getInstance() {
        if (instance == null) {
            instance = new LineView();
        }
        return instance;
    }

    public String getUplineStationName() {
        return InputView.getNameWithMessage(TO_REGISTER_PREFIX + REQUEST_UPLINE_NAME);
    }

    public String getDownlineStationName() {
        return InputView.getNameWithMessage(TO_REGISTER_PREFIX + REQUEST_DOWNLINE_NAME);
    }


}

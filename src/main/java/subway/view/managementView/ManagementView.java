package subway.view.managementView;

import subway.menuType.FunctionType;
import subway.dto.DTO;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.selection.Selection;
import subway.view.selection.Selections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class ManagementView {
    protected static final String FATAL_MENU_DATA_CRAHSED = "메뉴를 생성할 수 없습니다. ";
    protected static final String SHARP_PREFIX = "## ";
    protected static final String VIEW_NAME = "관리 화면";
    protected static final String TO_CREATE_PREFIX = "등록할 ";
    protected static final String TO_DELETE_PREFIX = "삭제할 ";
    protected static final String REQUEST_MESSAGE = "이름을 입력하세요.";
    protected static final String LIST = "목록";
    protected static final String MENU_ESCAPE = "돌아가기";
    protected static final String MENU_ESCAPE_VALUE = "B";
    protected static final int MENU_START_INDEX = 1;

    protected String itemPrefix;
    protected String viewName;
    protected String createMessage;
    protected String deleteMessage;
    protected Selections selections;
    protected HashMap<Selection, FunctionType> mapToFunctionType;

    protected void initializeSelections(List<String> descriptions) {
        Iterator<String> description = descriptions.iterator();
        List<Selection> selections = new ArrayList<>();

        for (int i = MENU_START_INDEX; i <= descriptions.size(); i++) {
            selections.add(new Selection(Integer.toString(i), description.next()));
        }
        selections.add(new Selection(MENU_ESCAPE_VALUE, MENU_ESCAPE));

        this.selections = new Selections(selections);
    }

    protected void initializeHashMapToFunctionType(List<Selection> selections, List<FunctionType> functionTypes) {
        if (selections.size() != functionTypes.size()) {
            throw new IllegalArgumentException(FATAL_MENU_DATA_CRAHSED);
        }
        Iterator<FunctionType> functionType = functionTypes.iterator();
        Iterator<Selection> selection = selections.iterator();

        this.mapToFunctionType = new HashMap<>();
        while (selection.hasNext() && functionType.hasNext()) {
            this.mapToFunctionType.put(selection.next(), functionType.next());
        }
    }

    protected FunctionType convertToFunctionType(Selection selection){
        return mapToFunctionType.get(selection);
    }

    public void showMenu() {
        OutputView.showMenu(selections, viewName);
    }

    public FunctionType getFunctionSelection() {
        Selection selection = InputView.getSelection(selections);
        return convertToFunctionType(selection);
    }

    public void printCreateDone() {
        OutputView.printWithInfoPrefix(createMessage);
    }

    public void printDeleteDone() {
        OutputView.printWithInfoPrefix(deleteMessage);
    }

    public String getNameToCreate() {
        return InputView.getNameWithMessage(SHARP_PREFIX + TO_CREATE_PREFIX + itemPrefix + REQUEST_MESSAGE);
    }

    public String getNameToDelete() {
        return InputView.getNameWithMessage(SHARP_PREFIX + TO_DELETE_PREFIX + itemPrefix + REQUEST_MESSAGE);
    }

    public void printAll(List<DTO> resultList) {
        System.out.println(SHARP_PREFIX + itemPrefix + LIST);
        for (DTO result : resultList) {
            OutputView.printWithInfoPrefix(result.getName());
        }
        newLine();
    }

    private void newLine() {
        System.out.println();
    }
}

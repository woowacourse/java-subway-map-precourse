package subway.view.managementView;

import subway.menuType.FunctionType;
import subway.dto.DTO;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.selection.Selection;
import subway.view.selection.Selections;

import java.util.HashMap;
import java.util.List;

public abstract class ManagementView {
    private static final String SHARP_PREFIX = "## ";
    private static final String TO_REGISTER_PREFIX = "등록할 ";
    private static final String TO_DELETE_PREFIX = "삭제할 ";
    private static final String REQUEST_MESSAGE = "이름을 입력하세요.";
    private static final String LIST = "목록";

    protected String itemPrefix;
    protected String viewName;
    protected String createMessage;
    protected String deleteMessage;
    protected Selections selections;
    protected HashMap<Selection, FunctionType> mapToFunctionType;

    protected abstract void initializeHashMapToFunctionType();

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

    public void printRegisterDone() {
        OutputView.printWithInfoPrefix(createMessage);
    }

    public void printDeleteDone() {
        OutputView.printWithInfoPrefix(deleteMessage);
    }

    public String getNameToCreate() {
        return InputView.getNameWithMessage(SHARP_PREFIX + TO_REGISTER_PREFIX + itemPrefix + REQUEST_MESSAGE);
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

package subway.view.menuView;

import subway.menuType.ManagementMenuType;
import subway.dto.DTO;
import subway.view.InputView;
import subway.view.OutputView;
import java.util.List;

public abstract class ManagementView extends MenuView<ManagementMenuType> {
    protected static final String VIEW_NAME = "관리 화면";
    protected static final String TO_CREATE_PREFIX = "등록할 ";
    protected static final String TO_DELETE_PREFIX = "삭제할 ";
    protected static final String REQUEST_MESSAGE = "이름을 입력하세요.";
    protected static final String LIST = "목록";
    protected static final String MENU_ESCAPE = "돌아가기";
    protected static final String MENU_ESCAPE_VALUE = "B";

    protected String itemPrefix;
    protected String createMessage;
    protected String deleteMessage;

    public void printCreateDone() {
        OutputView.printResponseMessage(createMessage);
        newLine();
    }

    public void printDeleteDone() {
        OutputView.printResponseMessage(deleteMessage);
        newLine();
    }

    public String getNameToCreate() {
        return InputView.getStringWithMessage(TO_CREATE_PREFIX + itemPrefix + REQUEST_MESSAGE);
    }

    public String getNameToDelete() {
        return InputView.getStringWithMessage(TO_DELETE_PREFIX + itemPrefix + REQUEST_MESSAGE);
    }

    public void printAll(List<DTO> resultList) {
        OutputView.printResponseMessage(itemPrefix + LIST);
        for (DTO result : resultList) {
            OutputView.printResponseMessage(result.getName());
        }
        newLine();
    }
}

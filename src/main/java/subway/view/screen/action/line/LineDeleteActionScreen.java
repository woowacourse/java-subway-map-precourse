package subway.view.screen.action.line;

import subway.CategoryType;
import subway.line.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.action.BaseActionScreen;

public class LineDeleteActionScreen extends BaseActionScreen {

    public static final String DELETE_INPUT_MESSAGE = "삭제할 노선 이름을 입력하세요.";
    public static final String DELETE_INPUT_SUCCESS_MESSAGE = "지하철 노선이 삭제되었습니다.";

    public LineDeleteActionScreen(CategoryType selectedCategoryType) {
        super(selectedCategoryType);
    }

    @Override
    public void visualize() {}

    @Override
    protected void action(InputView inputView) {
        OutputView.printTitle(DELETE_INPUT_MESSAGE);
        String lineName = inputView.readCommand();
        LineService.deleteByName(lineName);
        OutputView.printlnResult(DELETE_INPUT_SUCCESS_MESSAGE);
    }
}

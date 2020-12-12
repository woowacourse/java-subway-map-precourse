package subway.view.screen.action.line;

import subway.CategoryType;
import subway.line.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.action.BaseActionScreen;

public class LineSelectAllActionScreen extends BaseActionScreen {

    public LineSelectAllActionScreen(CategoryType selectedCategoryType) {
        super(selectedCategoryType);
    }

    @Override
    public void visualize() {}

    @Override
    protected void action(InputView inputView) {
        OutputView.printTitle(selectedCategoryType.getName() + SPACE + LIST_MESSAGE);
        LineService.findAll().forEach(
            lineResponseDto -> OutputView.printResult(lineResponseDto.getName()));
    }
}

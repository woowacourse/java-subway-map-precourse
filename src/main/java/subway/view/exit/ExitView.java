package subway.view.exit;

import subway.view.OutputView;
import subway.view.ViewStrategy;

public class ExitView implements ViewStrategy {
    private static final String VIEW_NAME = "종료";
    private static final String EXIT_MESSAGE = "시스템을 종료합니다.";

    @Override
    public String viewName() {
        return VIEW_NAME;
    }

    @Override
    public void show() {
        OutputView.infoView(EXIT_MESSAGE);
    }
}

package subway.view.executeViews;

import subway.view.ViewStrategy;

public class BackView implements ViewStrategy {
    private static final String VIEW_NAME = "뒤로 가기";

    @Override
    public void execute() {}

    @Override
    public String viewName() {
        return VIEW_NAME;
    }
}

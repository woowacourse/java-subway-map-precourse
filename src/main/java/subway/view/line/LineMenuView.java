package subway.view.line;

import subway.view.SelectionView;

public class LineMenuView extends SelectionView {

    private static final String VIEW_NAME = "노선 관리";

    @Override
    protected void initViewName() {
        this.name = VIEW_NAME;
    }
}

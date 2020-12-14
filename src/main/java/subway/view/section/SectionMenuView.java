package subway.view.section;

import subway.view.SelectionView;

public class SectionMenuView extends SelectionView {

    private static final String VIEW_NAME = "구간 관리";

    @Override
    protected void initViewName() {
        this.name = VIEW_NAME;
    }
}

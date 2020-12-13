package subway.view.station;

import subway.view.SelectionView;

public class StationMenuView extends SelectionView {

    private static final String VIEW_NAME = "역 관리";

    @Override
    protected void initViewName() {
        this.name = VIEW_NAME;
    }
}

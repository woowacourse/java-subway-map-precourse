package subway.view.stationManage;

import subway.view.OutputView;
import subway.view.ViewStrategy;

public class StationManageView implements ViewStrategy {
    private static final String VIEW_NAME = "역 관리";
    private static final String STATION_MANAGE_MESSAGE = "역 관리 화면";

    @Override
    public String viewName() {
        return VIEW_NAME;
    }

    @Override
    public void show() {
        OutputView.selectView(STATION_MANAGE_MESSAGE);
    }
}

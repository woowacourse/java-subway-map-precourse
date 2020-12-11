package subway.view;

import subway.view.lineManage.LineManageViewStrategy;
import subway.view.stationManage.StationManageViewStrategy;

public class BackView implements StationManageViewStrategy, LineManageViewStrategy {
    private static final String VIEW_NAME = "뒤로 가기";

    @Override
    public void show() {}

    @Override
    public String toString() {
        return VIEW_NAME;
    }
}

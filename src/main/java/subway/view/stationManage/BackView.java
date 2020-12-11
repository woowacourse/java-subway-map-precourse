package subway.view.stationManage;

public class BackView implements StationManageViewStrategy {
    private static final String VIEW_NAME = "뒤로 가기";

    @Override
    public void show() {}

    @Override
    public String toString() {
        return VIEW_NAME;
    }
}

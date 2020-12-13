package subway.view.station;

import subway.view.GeneralView;

public class StationQueryView extends GeneralView {

    private static final String VIEW_NAME = "역 조회";
    private static final String QUERY_GUIDE_TEXT = VIEW_TEXT_PREFIX + "역 목록";

    @Override
    protected void initViewName() {
        this.name = VIEW_NAME;
    }

    @Override
    public void setVisible() {
        /** TODO: StationService에게 조회 요청 */
    }
}

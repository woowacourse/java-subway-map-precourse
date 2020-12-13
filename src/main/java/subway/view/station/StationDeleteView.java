package subway.view.station;

import subway.view.GeneralView;

public class StationDeleteView extends GeneralView {

    private static final String VIEW_NAME = "역 삭제";
    private static final String INPUT_GUIDE_TEXT = VIEW_TEXT_PREFIX + "삭제할 역 이름을 입력하세요.";

    @Override
    protected void initViewName() {
        this.name = VIEW_NAME;
    }

    @Override
    public void setVisible() {
        String stationName = inputMoreThanTwoWords(VIEW_TEXT_PREFIX);
        /** TODO: StationService에게 역 삭제 요청 */
    }
}

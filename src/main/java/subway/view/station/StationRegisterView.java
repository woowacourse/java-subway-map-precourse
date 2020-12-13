package subway.view.station;

import subway.view.GeneralView;

public class StationRegisterView extends GeneralView {

    private static final String VIEW_NAME = "역 등록";
    private static final String INPUT_GUIDE_TEXT = VIEW_TEXT_PREFIX + "등록할 역 이름을 입력하세요.";


    @Override
    protected void initViewName() {
        this.name = VIEW_NAME;
    }

    @Override
    public void setVisible() {
        String stationName = inputMoreThanTwoWords(INPUT_GUIDE_TEXT);
        /** TODO: StationService에게 역 등록 요청 */
    }
}

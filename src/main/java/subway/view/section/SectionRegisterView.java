package subway.view.section;

import subway.view.GeneralView;

public class SectionRegisterView extends GeneralView {

    private static final String VIEW_NAME = "구간 등록";
    private static final String INPUT_REGISTER_LINE_GUIDE_TEXT = VIEW_TEXT_PREFIX + "노선을 입력하세요.";
    private static final String INPUT_REGISTER_STATION_GUIDE_TEXT = VIEW_TEXT_PREFIX + "역이름을 입력하세요.";
    private static final String INPUT_REGISTER_ORDER_GUIDE_TEXT = VIEW_TEXT_PREFIX + "순서를 입력하세요.";

    @Override
    protected void initViewName() {
        this.name = VIEW_NAME;
    }

    @Override
    public void setVisible() {
        String lineName = inputMoreThanTwoWords(INPUT_REGISTER_LINE_GUIDE_TEXT);
        String stationName = inputMoreThanTwoWords(INPUT_REGISTER_STATION_GUIDE_TEXT);
        int order = inputNumber(INPUT_REGISTER_ORDER_GUIDE_TEXT);
        /** SectionService에게 구간 등록 요청 */
    }
}

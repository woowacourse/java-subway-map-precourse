package subway.view.section;

import subway.view.GeneralView;

public class SectionDeleteView extends GeneralView {

    private static final String VIEW_NAME = "구간 삭제";
    private static final String INPUT_DELETE_LINE_GUIDE_TEXT = VIEW_TEXT_PREFIX + "삭제할 구간의 노선을 입력하세요.";
    private static final String INPUT_DELETE_STATION_GUIDE_TEXT = VIEW_TEXT_PREFIX + "삭제할 구간의 역을 입력하세요.";

    @Override
    protected void initViewName() {
        this.name = VIEW_NAME;
    }

    @Override
    public void setVisible() {
        String lineName = inputMoreThanTwoWords(INPUT_DELETE_LINE_GUIDE_TEXT);
        String stationName = inputMoreThanTwoWords(INPUT_DELETE_STATION_GUIDE_TEXT);
        /** TODO: SectionService에게 구간 삭제 요청 */
    }
}

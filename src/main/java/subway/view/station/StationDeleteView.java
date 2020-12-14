package subway.view.station;

import subway.model.ResultDto;
import subway.station.StationService;
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
        String stationName = inputMoreThanTwoWords(INPUT_GUIDE_TEXT);
        ResultDto result = StationService.deleteStation(stationName);
        processRequestResult(result);
    }
}

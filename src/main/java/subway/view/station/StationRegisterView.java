package subway.view.station;

import subway.model.ResultDto;
import subway.station.StationService;
import subway.view.GeneralView;

public class StationRegisterView extends GeneralView {

    private static final String VIEW_NAME = "역 등록";
    private static final String INPUT_GUIDE_TEXT = VIEW_TEXT_PREFIX + "등록할 역 이름을 입력하세요.";

    private final StationService stationService = StationService.getInstance();

    @Override
    protected void initViewName() {
        this.name = VIEW_NAME;
    }

    @Override
    public void setVisible() {
        String stationName = inputMoreThanTwoWords(INPUT_GUIDE_TEXT);
        ResultDto result = stationService.registerStation(stationName);

        println(result.getMessage());
        isBadResult(result);
    }
}

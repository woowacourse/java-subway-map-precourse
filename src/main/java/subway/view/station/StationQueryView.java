package subway.view.station;

import subway.model.ResultDto;
import subway.station.StationService;
import subway.view.GeneralView;

public class StationQueryView extends GeneralView {

    private static final String VIEW_NAME = "역 조회";
    private static final String QUERY_GUIDE_TEXT = VIEW_TEXT_PREFIX + "역 목록";

    private final StationService stationService = StationService.getInstance();

    @Override
    protected void initViewName() {
        this.name = VIEW_NAME;
    }

    @Override
    public void setVisible() {
        println(QUERY_GUIDE_TEXT);
        ResultDto result = stationService.findAllStationNames();
        println(result.getContent());
    }
}

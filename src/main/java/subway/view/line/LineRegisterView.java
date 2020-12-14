package subway.view.line;

import subway.line.LineService;
import subway.model.ResultDto;
import subway.view.GeneralView;

public class LineRegisterView extends GeneralView {

    private static final String VIEW_NAME = "노선 등록";
    private static final String INPUT_LINE_NAME_GUIDE_TEXT = VIEW_TEXT_PREFIX + "등록할 노선 이름을 입력하세요.";
    private static final String INPUT_UP_STATION_GUIDE_TEXT = VIEW_TEXT_PREFIX + "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_DOWN_STATION_GUIDE_TEXT = VIEW_TEXT_PREFIX + "등록할 노선의 하행 종점역 이름을 입력하세요.";

    @Override
    protected void initViewName() {
        this.name = VIEW_NAME;
    }

    @Override
    public void setVisible() {
        String lineName = inputMoreThanTwoWords(INPUT_LINE_NAME_GUIDE_TEXT);
        String upEndStation = inputMoreThanTwoWords(INPUT_UP_STATION_GUIDE_TEXT);
        String downEndStation = inputMoreThanTwoWords(INPUT_DOWN_STATION_GUIDE_TEXT);
        ResultDto result = LineService.registerLine(lineName, upEndStation, downEndStation);
        processRequestResult(result);
    }
}

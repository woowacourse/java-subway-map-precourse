package subway.view.line;

import subway.line.LineService;
import subway.model.ResultDto;
import subway.view.GeneralView;

public class LineQueryView extends GeneralView {

    private static final String VIEW_NAME = "노선 조회";
    private static final String QUERY_GUIDE_TEXT = VIEW_TEXT_PREFIX + "노선 목록";

    @Override
    protected void initViewName() {
        this.name = VIEW_NAME;
    }

    @Override
    public void setVisible() {
        println(QUERY_GUIDE_TEXT);
        ResultDto result = LineService.findAllStationNames();
        println(result.getContent());
    }
}

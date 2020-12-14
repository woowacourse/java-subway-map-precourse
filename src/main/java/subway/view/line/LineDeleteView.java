package subway.view.line;

import subway.line.LineService;
import subway.model.ResultDto;
import subway.view.GeneralView;

public class LineDeleteView extends GeneralView {

    private static final String VIEW_NAME = "노선 삭제";
    private static final String INPUT_GUIDE_TEXT = VIEW_TEXT_PREFIX + "삭제할 노선 이름을 입력하세요.";

    @Override
    protected void initViewName() {
        this.name = VIEW_NAME;
    }

    @Override
    public void setVisible() {
        String lineName = inputMoreThanTwoWords(INPUT_GUIDE_TEXT);
        ResultDto result = LineService.deleteLine(lineName);
        processRequestResult(result);
    }
}

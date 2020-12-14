package subway.view;

import subway.line.Line;
import subway.line.LineService;

import java.util.List;

public class PrintSubwayLineView extends GeneralView {

    private static final String VIEW_NAME = "지하철 노선도 출력";
    private static final String PRINT_SUBWAY_LINE_MAP_GUIDE_TEXT = VIEW_TEXT_PREFIX + "지하철 노선도";

    @Override
    protected void initViewName() {
        this.name = VIEW_NAME;
    }

    @Override
    public void setVisible() {
        println(PRINT_SUBWAY_LINE_MAP_GUIDE_TEXT);
        List<Line> lines = LineService.findAll();
        for (Line line : lines) {
            println(line.toString());
        }
    }
}

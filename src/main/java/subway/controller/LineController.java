package subway.controller;

import java.util.List;
import subway.domain.Line;
import subway.service.LineService;
import subway.view.OutputView;

public class LineController {
    private OutputView monitor;

    public LineController(OutputView monitor) {
        this.monitor = monitor;
    }

    public boolean registerLine(String lineName
        , String upTrainLastStationName, String downTrainLastStationName) {
        try {
            LineService.register(lineName, upTrainLastStationName, downTrainLastStationName);
            monitor.print(OutputView.SUCCESS_TO_REGISTER_LINE_MESSAGE);
            return false;
        } catch (Exception e) {
            monitor.print(e.getMessage());
            return true;
        }
    }

    public boolean deleteLine(String lineName) {
        try {
            LineService.delete(lineName);
            monitor.print(OutputView.SUCCESS_TO_DELETE_LINE_MESSAGE);
            return false;
        } catch (Exception e) {
            monitor.print(e.getMessage());
            return true;
        }
    }

    public List<Line> searchLine() {
        return LineService.search();
    }
}

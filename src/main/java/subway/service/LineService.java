package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;

import java.util.List;

public class LineService {

    public static void addLine(String lineName, String upLineLastStop, String downLineLastStop){
        LineRepository.addLine(new Line(lineName, upLineLastStop, downLineLastStop));
    }

    public static void deleteLine(String lineName) {
        Line line = LineRepository.findLineByName(lineName);
        line.deleteLine();
    }

    public static List<Line> getLineList() {
        return LineRepository.lines();
    }
}

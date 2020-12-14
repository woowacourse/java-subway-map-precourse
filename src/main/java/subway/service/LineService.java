package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;

public class LineService {

    public void registerLine(String lineName) {
        Line newLine = new Line(lineName);
        LineRepository.addLine(newLine);
    }

    public void deleteLine(String lineName) {
        LineRepository.deleteLineByName(lineName);
    }
}

package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class LineService {

    public void registerLine(String lineName, Station topStation, Station bottomStation) {
        Line newLine = new Line(lineName);
        newLine.addIntervals(topStation);
        newLine.addIntervals(bottomStation);
        LineRepository.addLine(newLine);

    }

    public void deleteLine(String lineName) {
        LineRepository.deleteLineByName(lineName);
    }
}

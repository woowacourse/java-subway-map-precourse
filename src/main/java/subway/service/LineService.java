package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class LineService {

    public void registerLine(String lineName, Station topStation, Station bottomStation) {
        Line newLine = new Line(lineName);
        newLine.addIntervals(topStation, 1);
        newLine.addIntervals(bottomStation, 2);
        topStation.addRegisteredLine(newLine);
        bottomStation.addRegisteredLine(newLine);
        LineRepository.addLine(newLine);
    }

    public void deleteLine(String lineName) {
        LineRepository.deleteLineByName(lineName);
    }
}

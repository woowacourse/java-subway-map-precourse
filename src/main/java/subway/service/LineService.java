package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.SectionRepository;
import subway.repository.StationRepository;

/**
 * @author yhh1056
 * @since 2020/12/13
 */
public class LineService {
    public boolean addLine(String name) {
        LineRepository.addLine(new Line(name));
        return true;
    }

    public boolean addSection(String name, String firstStationName, String lastStationName) {
        Station firstStation = StationRepository.findOne(firstStationName);
        Station lastStation = StationRepository.findOne(lastStationName);

        Line line = LineRepository.findOne(name);

        SectionRepository.addSection(line, firstStation);
        SectionRepository.addSection(line, lastStation);
        return true;
    }

    public boolean deleteLine(String name) {
        if (LineRepository.deleteLineByName(name)) {
            return true;
        }
        return false;
    }
}

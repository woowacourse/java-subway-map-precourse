package subway.service;

import static subway.console.Output.print;

import java.util.Collections;
import java.util.List;
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
        try {
            LineRepository.addLine(new Line(name));
            return true;
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
            return false;
        }
    }

    public boolean addSection(String name, String stationName) {
        Line line = LineRepository.findLineByName(name);
        try {
            Station station = StationRepository.findByName(stationName);

            SectionRepository.addSection(line, station);
            return true;
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
            LineRepository.deleteLine(line);
            return false;
        }
    }

    public boolean deleteLine(String name) {
        try {
            Line line = LineRepository.findLineByName(name);
            LineRepository.deleteLine(line);
            return true;
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
            return false;
        }
    }

    public List<Line> findAll() {
        try {
            return LineRepository.lines();
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
            return Collections.emptyList();
        }
    }
}

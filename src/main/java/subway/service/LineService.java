package subway.service;

import static subway.console.Output.print;

import java.util.List;
import subway.console.Message;
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
    private static final int STATION_NAME_LENGTH = 2;
    private static final String STATION_END_NAME = "선";

    public boolean addLine(String name) {
        if (isValidate(name)) {
            LineRepository.addLine(new Line(name));
            return true;
        }
        return false;
    }

    private boolean isValidate(String name) {
        try {
            validateNameLength(name);
            validateNameEndWord(name);
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
            return false;
        }
        return true;
    }

    private void validateNameLength(String name) {
        if (name.length() < STATION_NAME_LENGTH) {
            throw new IllegalArgumentException(Message.ERROR_NAME_LENGTH);
        }
    }

    private void validateNameEndWord(String name) {
        if (!name.endsWith(STATION_END_NAME)) {
            throw new IllegalArgumentException(Message.ERROR_LINE_NAME_END);
        }
    }

    public boolean addSection(String name, String stationName) {
        Station station = StationRepository.findOne(stationName);
        Line line = LineRepository.findOne(name);

        SectionRepository.addSection(line, station);
        return true;
    }

    public boolean deleteLine(String name) {
        return LineRepository.deleteLineByName(name);
    }

    public List<Line> findAll() {
        return LineRepository.lines();
    }
}

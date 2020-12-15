package subway.service;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.domain.station.Station;
import subway.repository.line.LineRepository;

import java.util.List;

public class SectionListService {
    private final LineRepository lineRepository;

    public SectionListService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public List<Station> get(LineName lineName) {
        Line line = lineRepository.findLineByName(lineName);
        return line.sections();
    }
}

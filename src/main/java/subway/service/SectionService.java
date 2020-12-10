package subway.service;

import subway.domain.line.LineRepository;
import subway.domain.station.StationRepository;

public class SectionService {
    private final LineRepository lineRepository;
    private final StationRepository stationRepository;

    public SectionService(LineRepository lineRepository, StationRepository stationRepository) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }
}

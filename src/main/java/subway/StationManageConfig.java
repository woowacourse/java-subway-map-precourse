package subway;

import subway.domain.line.LineRepository;
import subway.domain.line.LineService;
import subway.domain.line.LineServiceImpl;
import subway.domain.line.MemoryLineRepository;
import subway.domain.section.MemorySectionRepository;
import subway.domain.section.SectionService;
import subway.domain.station.MemoryStationRepository;
import subway.domain.station.StationRepository;
import subway.domain.station.StationService;
import subway.domain.station.StationServiceImpl;

public class StationManageConfig {
    public StationManageConfig() {
    }

    public StationService stationService() {
        return new StationServiceImpl(stationRepository(), sectionRepository());
    }

    public StationRepository stationRepository() {
        return MemoryStationRepository.of();
    }

    public LineService lineService() {
        return new LineServiceImpl(lineRepository());
    }

    public LineRepository lineRepository() {
        return MemoryLineRepository.of();
    }

    public SectionService sectionService() {
        return new SectionService(lineRepository(), stationRepository(), sectionRepository());
    }

    public MemorySectionRepository sectionRepository() {
        return MemorySectionRepository.of();
    }
}

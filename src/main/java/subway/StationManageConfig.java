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
import subway.service.input.InputService;
import subway.service.input.ScannerInputService;
import subway.service.output.OutputService;
import subway.service.output.StringBuilderOutputService;
import subway.view.LineView;
import subway.view.SectionView;
import subway.view.StationView;

import java.util.Scanner;

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

    public InputService inputService() {
        return ScannerInputService.of(new Scanner(System.in));
    }

    public OutputService outputService() {
        return StringBuilderOutputService.of(new StringBuilder());
    }

    public Manage stationManage() {
        return new StationManage(inputService(), stationService(), new StationView(outputService()));
    }

    public Manage lineManage() {
        return new LineManage(inputService(), sectionService(), lineService(), stationService(), new LineView(outputService()));
    }

    public Manage sectionManage() {
        return new SectionManage(inputService(), sectionService(), stationService(), new SectionView(outputService()));
    }
}

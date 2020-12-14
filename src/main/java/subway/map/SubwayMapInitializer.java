package subway.map;

import subway.controller.*;
import subway.domain.entity.Sections;
import subway.domain.entity.Station;
import subway.domain.repository.LineRepository;
import subway.domain.repository.StationRepository;
import subway.dto.LineDto;
import subway.dto.SectionDto;
import subway.service.LineService;
import subway.service.StationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubwayMapInitializer {
    private static final List<String> DEFAULT_STATION_NAMES_DATA =
            Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final List<String> DEFAULT_LINE_NAMES_DATA = Arrays.asList("2호선", "3호선", "신분당선");
    private static final List<LineDto> DEFAULT_LAST_STATIONS_DATA =
            Arrays.asList(new LineDto("", "교대역", "역삼역"),
                    new LineDto("", "교대역", "매봉역"),
                    new LineDto("", "강남역", "양재시민의숲역"));
    private static final List<SectionDto> DEFAULT_SECTION_REGISTRATION_REQUEST_DATA =
            Arrays.asList(new SectionDto("2호선", "강남역", 2),
                    new SectionDto("3호선", "남부터미널역", 2),
                    new SectionDto("3호선", "양재역", 3),
                    new SectionDto("신분당선", "양재역", 2));
    private static final int ZERO = 0;

    private SubwayMapInitializer() {
    }

    public static ControllerMapper injectDependencies() {
        StationRepository stationRepository = new StationRepository(new ArrayList<>());
        LineRepository lineRepository = new LineRepository(new ArrayList<>());
        StationService stationService = new StationService(stationRepository);
        LineService lineService = new LineService(lineRepository);
        saveDefaultData(stationService, lineService);
        List<SubwayMapController> subwayMapControllers =
                generateSubwayMapControllers(stationService, lineService);
        return new ControllerMapper(subwayMapControllers);
    }

    private static void saveDefaultData(StationService stationService, LineService lineService) {
        DEFAULT_STATION_NAMES_DATA.forEach(stationService::addStationByName);
        saveDefaultLines(stationService, lineService);
        saveDefaultSections(stationService, lineService);
    }

    private static void saveDefaultLines(StationService stationService, LineService lineService) {
        List<Sections> sections = DEFAULT_LAST_STATIONS_DATA.stream()
                .map(stationService::createSections)
                .collect(Collectors.toList());
        int lineCounts = DEFAULT_LINE_NAMES_DATA.size();
        IntStream.range(ZERO, lineCounts)
                .forEach(i -> lineService.addLine(DEFAULT_LINE_NAMES_DATA.get(i), sections.get(i)));
    }

    private static void saveDefaultSections(StationService stationService, LineService lineService) {
        DEFAULT_SECTION_REGISTRATION_REQUEST_DATA.forEach(sectionDto -> {
            Station station = stationService.findStationByName(sectionDto.getStationName());
            lineService.addSection(sectionDto, station);
        });
    }

    private static List<SubwayMapController> generateSubwayMapControllers(StationService stationService,
                                                                          LineService lineService) {
        StationController stationController = new StationController(stationService);
        LineController lineController = new LineController(stationService, lineService);
        SectionController sectionController = new SectionController(stationService, lineService);
        return Arrays.asList(stationController, lineController, sectionController);
    }
}

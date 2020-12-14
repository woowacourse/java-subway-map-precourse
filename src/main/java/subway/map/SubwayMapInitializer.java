package subway.map;

import subway.controller.SubwayMapController;
import subway.domain.repository.LineRepository;
import subway.domain.repository.StationRepository;
import subway.dto.LineDto;
import subway.dto.SectionDto;
import subway.service.LineService;
import subway.service.StationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubwayMapInitializer {
    private static final List<String> DEFAULT_STATION_NAMES_DATA =
            Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final List<LineDto> DEFAULT_LINE_REGISTRATION_REQUEST_DATA =
            Arrays.asList(new LineDto("2호선", "교대역", "역삼역"),
                    new LineDto("3호선", "교대역", "매봉역"),
                    new LineDto("신분당선", "강남역", "양재시민의숲역"));
    private static final List<SectionDto> DEFAULT_SECTION_REGISTRATION_REQUEST_DATA =
            Arrays.asList(new SectionDto("2호선", "강남역", 2),
                    new SectionDto("3호선", "남부터미널역", 2),
                    new SectionDto("3호선", "양재역", 3),
                    new SectionDto("신분당선", "양재역", 2));

    private SubwayMapInitializer() {
    }

    public static SubwayMapController injectDependencies() {
        StationRepository stationRepository = new StationRepository(new ArrayList<>());
        LineRepository lineRepository = new LineRepository(new ArrayList<>());
        StationService stationService = new StationService(stationRepository);
        LineService lineService = new LineService(lineRepository);
        return new SubwayMapController(stationService, lineService);
    }

    public static void loadDefaultData(SubwayMapController subwayMapController) {
        DEFAULT_STATION_NAMES_DATA.forEach(subwayMapController::addStationByName);
        DEFAULT_LINE_REGISTRATION_REQUEST_DATA.forEach(subwayMapController::addLine);
        DEFAULT_SECTION_REGISTRATION_REQUEST_DATA.forEach(subwayMapController::addSection);
    }
}

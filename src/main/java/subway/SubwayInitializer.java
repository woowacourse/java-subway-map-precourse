package subway;

import java.util.Arrays;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.service.LineService;

public class SubwayInitializer {

    public static final String LINE_2호선 = "2호선";
    public static final String LINE_3호선 = "3호선";
    public static final String LINE_신분당선 = "신분당선";
    public static final String STATION_교대역 = "교대역";
    public static final String STATION_강남역 = "강남역";
    public static final String STATION_역삼역 = "역삼역";
    public static final String STATION_남부터미널역 = "남부터미널역";
    public static final String STATION_양재역 = "양재역";
    public static final String STATION_양재시민의숲역 = "양재시민의숲역";
    public static final String STATION_매봉역 = "매봉역";

    public static void init() {
        initStations();
        initLines();
        initSections();
    }

    private static void initStations() {
        Arrays.asList(STATION_교대역, STATION_강남역, STATION_역삼역, STATION_남부터미널역, STATION_양재역,
                STATION_양재시민의숲역, STATION_매봉역)
                .forEach(name -> Station.from(name).save());
    }

    private static void initLines() {
        Arrays.asList(
                Line.of(LINE_2호선, StationRepository.findByName(STATION_교대역),
                        StationRepository.findByName(STATION_역삼역)),
                Line.of(LINE_3호선, StationRepository.findByName(STATION_교대역),
                        StationRepository.findByName(STATION_매봉역)),
                Line.of(LINE_신분당선, StationRepository.findByName(STATION_강남역),
                        StationRepository.findByName(STATION_양재시민의숲역))
        ).forEach(Line::save);
    }

    private static void initSections() {
        LineService.insertSection(LINE_2호선, STATION_강남역, 1);
        LineService.insertSection(LINE_3호선, STATION_남부터미널역, 1);
        LineService.insertSection(LINE_3호선, STATION_양재역, 2);
        LineService.insertSection(LINE_신분당선, STATION_양재역, 1);
    }
}

package subway;

import java.util.Arrays;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.service.LineService;

public class SubwayInitializer {

    public static final String LINE_2호선 = "2호선";
    public static final String 교대역 = "교대역";
    public static final String 강남역 = "강남역";
    public static final String 역삼역 = "역삼역";
    public static final String 남부터미널역 = "남부터미널역";
    public static final String 양재역 = "양재역";
    public static final String 양재시민의숲역 = "양재시민의숲역";
    public static final String 매봉역 = "매봉역";
    public static final String LINE_3호선 = "3호선";
    public static final String LINE_신분당선 = "신분당선";

    public static void init() {
        initStations();
        initLines();
        initSections();
    }

    private static void initStations() {
        Arrays.asList(교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역)
                .forEach(name -> Station.from(name).save());

        // todo 구간 저장
        //   - 2호선: 교대역 - 강남역 - 역삼역
        //   - 3호선: 교대역 - 남부터미널역 - 양재역 - 매봉역
        //   - 신분당선: 강남역 - 양재역 - 양재시민의숲역
    }

    private static void initLines() {
        Arrays.asList(
                Line.of(LINE_2호선, Station.from(교대역), Station.from(역삼역)),
                Line.of(LINE_3호선, Station.from(교대역), Station.from(매봉역)),
                Line.of(LINE_신분당선, Station.from(강남역), Station.from(양재시민의숲역)))
                .forEach(Line::save);
    }

    private static void initSections() {
        LineService.insertStationInLine(LINE_2호선, 강남역, 1);
        LineService.insertStationInLine(LINE_3호선, 남부터미널역, 1);
        LineService.insertStationInLine(LINE_3호선, 양재역, 2);
        LineService.insertStationInLine(LINE_신분당선, 양재역, 1);
    }
}

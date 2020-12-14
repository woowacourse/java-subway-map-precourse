package subway;

import java.util.Arrays;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayInitializer {

    public static void init() {
        initStations();
        initLines();
    }

    private static void initStations() {
        Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역")
                .forEach(name -> Station.from(name).save());

        // todo 구간 저장
        //   - 2호선: 교대역 - 강남역 - 역삼역
        //   - 3호선: 교대역 - 남부터미널역 - 양재역 - 매봉역
        //   - 신분당선: 강남역 - 양재역 - 양재시민의숲역
    }

    private static void initLines() {
        Arrays.asList(
                Line.of("2호선", Station.from("교대역"), Station.from("역삼역")),
                Line.of("3호선", Station.from("교대역"), Station.from("매봉역")),
                Line.of("신분당선", Station.from("강남역"), Station.from("양재시민의숲역")))
                .forEach(Line::save);
    }
}

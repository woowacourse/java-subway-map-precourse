package subway;

import java.util.Arrays;
import subway.domain.Line;
import subway.domain.Station;

public class SubwayInitializer {

    public static void init() {
        initStations();
    }

    private static void initStations() {
        Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역")
                .forEach(name -> Station.from(name).save());
        Line line1 = Line.of("2호선", Station.from("교대역"), Station.from("역삼역"));
        Line line2 = Line.of("3호선", Station.from("교대역"), Station.from("매봉역"));
        Line line3 = Line.of("신분당선", Station.from("강남역"), Station.from("양재시민의숲역"));

        Arrays.asList(line1, line2, line3)
                .forEach(Line::save);

        // todo 구간 저장
        // ## 노선을 입력하세요.
        // 2호선
        // ## 역이름을 입력하세요.
        // 잠실역
        // ## 순서를 입력하세요.
        // 2

        //   - 2호선: 교대역 - 강남역 - 역삼역
        //   - 3호선: 교대역 - 남부터미널역 - 양재역 - 매봉역
        //   - 신분당선: 강남역 - 양재역 - 양재시민의숲역
    }
}

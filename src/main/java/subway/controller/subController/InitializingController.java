package subway.controller.subController;

import java.util.Arrays;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class InitializingController implements Controllable {
    @Override
    public void process() {
        Arrays.stream(Station.values()).map(station -> station.name)
                .map(subway.domain.Station::new)
                .forEach(StationRepository::addStation);
        Arrays.stream(Line.values()).map(line -> line.name)
                .map(subway.domain.Line::new)
                .forEach(LineRepository::addLine);
        System.out.println(StationRepository.stations());
        System.out.println(LineRepository.lines());
    }

    private enum Station {
        GYO_DAE("교대역"),
        GANG_NAM("강남역"),
        YEOK_SAM("역삼역"),
        NAMBU_TERMINAL("남부터미널역"),
        YANGJAE("양재역"),
        YANGJAE_FOREST("양재시민의숲역"),
        MAE_BONG("매봉역");

        private final String name;

        Station(String name) {
            this.name = name;
        }
    }

    private enum Line {
        LINE_TWO("2호선"),
        LINE_THREE("3호선"),
        LINE_SHINBOONDANG("신분당선");

        private final String name;

        Line(String name) {
            this.name = name;
        }
    }
}

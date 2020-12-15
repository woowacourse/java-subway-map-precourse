package subway;

import java.util.Arrays;
import java.util.List;

public class InitData {

    public enum InitStation {
        교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역
    }

    public enum InitLine {
        이호선("2호선", Arrays.asList(InitStation.교대역, InitStation.강남역, InitStation.역삼역)),
        삼호선("3호선",
            Arrays.asList(InitStation.교대역, InitStation.남부터미널역, InitStation.양재역, InitStation.매봉역)),
        신분당선("신분당선", Arrays.asList(InitStation.강남역, InitStation.양재역, InitStation.양재시민의숲역));

        private final String lineName;
        private final List<InitStation> stations;

        InitLine(String lineName, List<InitStation> stations) {
            this.lineName = lineName;
            this.stations = stations;
        }

        public String getInitLineName() {
            return lineName;
        }

        public List<InitStation> getInitStations() {
            return stations;
        }
    }
}

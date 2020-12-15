package subway.administer;

import java.util.Map;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.repository.PassingRouteRepository;
import subway.domain.repository.StationRepository;
import subway.domain.repository.LineRepository;

public class InitialConfiguration {

    String [] stationNames;
    String [] lineNames;
    Map<String, String[]> StationsForLine;

    InitialConfiguration() {
        stationNames = new String[]{"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
        lineNames = new String[]{"2호선", "3호선", "신분당선"};
        StationsForLine = Map.of(
            "2호선", new String[]{"교대역", "강남역", "역삼역"},
            "3호선", new String[]{"교대역", "남부터미널역", "양재역", "매봉역"},
            "신분당선", new String[]{"강남역", "양재역", "양재시민의숲역"}
        );
    }

    private void configureStations() {
        for(String stationName: stationNames) {
            StationRepository.addBack(new Station(stationName));
        }
    }

    private void configureLines() {
        for(String lineName: lineNames) {
            LineRepository.addBack(new Line(lineName, new PassingRouteRepository(StationsForLine.get(lineName))));
        }
    }

    public void initConfigure() {
        configureStations();
        configureLines();
    }

}

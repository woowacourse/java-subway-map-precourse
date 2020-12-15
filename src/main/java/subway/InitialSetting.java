package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitialSetting {
    public void setting() {
        List<String> stationNames = new ArrayList<>(Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
        addInitialStations(stationNames);
        stationNames = new ArrayList<>(Arrays.asList("교대역", "강남역", "역삼역"));
        addInitialLine("2호선", stationNames);
        stationNames = new ArrayList<>(Arrays.asList("교대역", "남부터미널역", "양재역"));
        addInitialLine("3호선", stationNames);
        stationNames = new ArrayList<>(Arrays.asList("강남역", "양재역", "양재시민의숲역"));
        addInitialLine("신분당선", stationNames);
    }

    public void addInitialStations(List<String> stationNames) {
        for (String name : stationNames) {
            Station station = new Station(name);
            StationRepository.addStation(station);
        }
    }

    public void addInitialLine(String lineName, List<String> stationNames) {
        List<Station> stations = new ArrayList<>();
        for (String name : stationNames) {
            Station station = StationRepository.selectOneStationByName(name);
            stations.add(station);
        }
        Line line = new Line(lineName, stations);
        LineRepository.addLine(line);
    }
}

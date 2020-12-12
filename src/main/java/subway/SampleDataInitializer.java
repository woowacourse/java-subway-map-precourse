package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SampleDataInitializer {
    
    public static void initialStationRepository() {
        List<String> initialStations = new ArrayList<>(Arrays.asList(
                "교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"
        ));
        initialStations.stream()
                .map(Station::new)
                .forEach(StationRepository::addStation);
    }

    public static void initialLineRepository() {
        line2Initialize();
        line3Initialize();
        shinbundangLineInitialize();
    }

    private static void line2Initialize() {
        Line line2 = new Line("2호선");
        List<String> line2Stations = new ArrayList<>(Arrays.asList(
                "교대역", "강남역", "역삼역"
        ));
        for (String stationName : line2Stations) {
            line2.addStation(StationRepository.searchByName(stationName));
        }
        LineRepository.addLine(line2);
    }

    private static void line3Initialize() {
        Line line3 = new Line("3호선");
        List<String> line3Stations = new ArrayList<>(Arrays.asList(
                "교대역", "남부터미널역", "양재역", "매봉역"
        ));
        for (String stationName : line3Stations) {
            line3.addStation(StationRepository.searchByName(stationName));
        }
        LineRepository.addLine(line3);
    }

    private static void shinbundangLineInitialize() {
        Line shinbundangLine = new Line("신분당선");
        List<String> shinbundangLineStation = new ArrayList<>(Arrays.asList(
                "교대역", "남부터미널역", "양재역", "매봉역"
        ));
        for (String stationName : shinbundangLineStation) {
            shinbundangLine.addStation(StationRepository.searchByName(stationName));
        }
        LineRepository.addLine(shinbundangLine);
    }

}

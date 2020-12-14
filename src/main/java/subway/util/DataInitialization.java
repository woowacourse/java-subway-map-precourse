package subway.util;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class DataInitialization {
    private static final String[] initialStation = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};

    public static void initialize() {
        initializeStations();
        initializeLines();
        inputStationsToLines();
    }

    private static void inputStationsToLines() {
        LineRepository.lines().get(0).addStation("강남역", "2"); // 2호선
        LineRepository.lines().get(1).addStation("남부터미널역", "2"); // 3호선
        LineRepository.lines().get(1).addStation("양재역", "3");
        LineRepository.lines().get(2).addStation("양재역", "2"); // 신분당선
    }

    private static void initializeLines() {
        LineRepository.initializeLine("2호선", "교대역", "역삼역");
        LineRepository.initializeLine("3호선", "교대역", "매봉역");
        LineRepository.initializeLine("신분당선", "강남역", "양재시민의숲역");
    }

    private static void initializeStations() {
        for (String stationName : initialStation) {
            StationRepository.addStation(stationName);
        }
    }
}

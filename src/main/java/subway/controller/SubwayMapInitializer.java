package subway.controller;

import java.util.Arrays;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayMapInitializer {

    private static List<String> initialLineSecond = Arrays.asList("교대역", "강남역", "역삼역");
    private static List<String> initialLineThird = Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역");
    private static List<String> initialLineShinbundang = Arrays.asList("강남역", "양재역", "양재시민의숲역");
    private static List<String> initialStation = Arrays
        .asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static List<String> initialLine = Arrays.asList("2호선", "3호선", "신분당선");

    public static void initializeStation() {
        initialStation
            .forEach(initialStation -> StationRepository.addStation(new Station(initialStation)));
    }

    public static void initializeLine() {
        initialLine.forEach(initializeLine -> LineRepository.addLine(new Line(initializeLine)));
    }

    public static void initializeLineSecond() {
        Line lineSecond = LineRepository.searchLineByName("2호선");
        for (int i = 0; i < initialLineSecond.size(); i++) {
            lineSecond.addStationInLine(i + 1,
                StationRepository.searchStationByName(initialLineSecond.get(i)));
        }
    }

    public static void initializeLineThird() {
        Line lineThird = LineRepository.searchLineByName("3호선");
        for (int i = 0; i < initialLineThird.size(); i++) {
            lineThird.addStationInLine(i + 1,
                StationRepository.searchStationByName(initialLineThird.get(i)));
        }
    }

    public static void initializeLineShinbundang() {
        Line lineShinbundang = LineRepository.searchLineByName("신분당선");
        for (int i = 0; i < initialLineShinbundang.size(); i++) {
            lineShinbundang.addStationInLine(i + 1,
                StationRepository.searchStationByName(initialLineShinbundang.get(i)));
        }
    }
}

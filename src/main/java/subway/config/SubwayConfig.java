package subway.config;

import subway.domain.*;

import java.util.Arrays;

public class SubwayConfig {

    public static void subwayMapInit() {
        lineInit();
        stationInit();
        subwayInit();
    }

    private static void subwayInit() {
        SubwayRepository.addStationOnTheLine(new Line("2호선"), Arrays.asList(new Station("교대역"),
                new Station("강남역"), new Station("역삼역")));

        SubwayRepository.addStationOnTheLine(new Line("3호선"), Arrays.asList(new Station("교대역"),
                new Station("남부터미널역"), new Station("양재역"), new Station("매봉역")));

        SubwayRepository.addStationOnTheLine(new Line("신분당선"), Arrays.asList(new Station("강남역"),
                new Station("양재역"), new Station("양재시민의숲역")));
    }

    private static void stationInit() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
    }

    private static void lineInit() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }
}

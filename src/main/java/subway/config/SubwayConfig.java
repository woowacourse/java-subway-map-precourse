package subway.config;

import subway.domain.*;

import java.util.ArrayList;
import java.util.Arrays;

public class SubwayConfig {

    public static void subwayMapInit() {
        lineInit();
        stationInit();
        subwayInit();
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

    private static void subwayInit() {
        SubwayRepository.addStationOnTheLine(LineRepository.getLine("2호선"),
                new ArrayList<>(Arrays.asList(
                        StationRepository.getStation("교대역"),
                        StationRepository.getStation("강남역"),
                        StationRepository.getStation("역삼역"))));

        SubwayRepository.addStationOnTheLine(LineRepository.getLine("3호선"),
                new ArrayList<>(Arrays.asList(
                        StationRepository.getStation("교대역"),
                        StationRepository.getStation("남부터미널역"),
                        StationRepository.getStation("양재역"),
                        StationRepository.getStation("매봉역"))));

        SubwayRepository.addStationOnTheLine(LineRepository.getLine("신분당선"),
                new ArrayList<>(Arrays.asList(
                        StationRepository.getStation("강남역"),
                        StationRepository.getStation("양재역"),
                        StationRepository.getStation("양재시민의숲역"))));
    }
}

package subway.domain;

import java.util.List;

public class Initializer {
    private static final List<String> stations = List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final List<String> lines = List.of("2호선", "3호선", "신분당선");

    public static void init() {
        initStations();
        initLines();
        initLineNumber2();
        initLinenUmber3();
        initLineSinboondang();
    }

    private static void initLineSinboondang() {
        SectionRepository.initSection(LineRepository.getLineByName("신분당선"), List.of("강남역", "양재역", "양재시민의숲역"));
    }

    private static void initLinenUmber3() {
        SectionRepository.initSection(LineRepository.getLineByName("3호선"), List.of("교대역", "남부터미널역", "양재역", "매봉역"));
    }

    private static void initStations() {
        stations.stream()
                .map(StationMaker::make)
                .forEach(StationRepository::addStation);
    }

    private static void initLines() {
        lines.stream()
                .map(LineMaker::make)
                .forEach(LineRepository::addLine);
    }

    private static void initLineNumber2() {
        SectionRepository.initSection(LineRepository.getLineByName("2호선"), List.of("교대역", "강남역", "역삼역"));
    }
}

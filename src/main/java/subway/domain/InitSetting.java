package subway.domain;

import java.util.Arrays;
import java.util.List;

public class InitSetting {
    public static void initSetting() {
        List<String> initStations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        List<String> initLines = Arrays.asList("2호선", "3호선", "신분당선");

        addInitStations(initStations);
        addInitLines(initLines);
        for (Line line : LineRepository.lines()) {
            SubwayRepository.addLine(line);
            addInitSecondLine(initStations, line);
            addInitThirdLine(initStations, line);
            addInitSinLine(initStations, line);
        }
    }

    private static void addInitStations(List<String> initStations) {
        for (String station : initStations) {
            StationRepository.addStation(new Station(station));
        }
    }

    private static void addInitLines(List<String> initLines) {
        for (String line : initLines) {
            LineRepository.addLine(new Line(line));
        }
    }

    private static void addInitSecondLine(List<String> initStations, Line line) {
        if (line.isSameNameThan("2호선")) {
            List<Integer> initSecondStations = Arrays.asList(0, 1, 2);
            for (Integer index : initSecondStations) {
                SubwayRepository.addStationInLine(line, StationRepository.findStationByName(initStations.get(index)));
            }
        }
    }

    private static void addInitThirdLine(List<String> initStations, Line line) {
        if (line.isSameNameThan("3호선")) {
            List<Integer> initSecondStations = Arrays.asList(0, 3, 4, 6);
            for (Integer index : initSecondStations) {
                SubwayRepository.addStationInLine(line, StationRepository.findStationByName(initStations.get(index)));
            }
        }
    }

    private static void addInitSinLine(List<String> initStations, Line line) {
        if (line.isSameNameThan("신분당선")) {
            List<Integer> initSecondStations = Arrays.asList(1, 4, 5);
            for (Integer index : initSecondStations) {
                SubwayRepository.addStationInLine(line, StationRepository.findStationByName(initStations.get(index)));
            }
        }
    }
}

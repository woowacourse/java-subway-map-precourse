package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public class InitialSetupController {
    private static final List<String> preregisterStations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final String SECOND_LINE = "2호선";
    private static final String THIRD_LINE = "3호선";
    private static final String NEW_BOONDANG_LINE = "신분당선";
    private static final List<String> secondLineStations = Arrays.asList("교대역", "강남역", "역삼역");
    private static final List<String> thirdLineStations = Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역");
    private static final List<String> newBoondangLineStations = Arrays.asList("강남역", "양재역", "양재시민의숲역");

    public static void initialSetup() {
        initialSetupStation();
        initialSetupSecondLine();
        initialSetupThirdLine();
        initialSetupNewBoondangLine();
    }

    private static void initialSetupStation() {
        for (String station : preregisterStations) {
            StationRepository.addStation(new Station(station));
        }
    }

    private static void initialSetupSecondLine() {
        Line secondLine = new Line(SECOND_LINE);
        for (String stationName : secondLineStations) {
            secondLine.addStationsInLine(StationRepository.getStationByName(stationName));
        }
        LineRepository.addLine(secondLine);
    }

    private static void initialSetupThirdLine() {
        Line thirdLine = new Line(THIRD_LINE);
        for (String stationName : thirdLineStations) {
            thirdLine.addStationsInLine(StationRepository.getStationByName(stationName));
        }
        LineRepository.addLine(thirdLine);
    }

    private static void initialSetupNewBoondangLine() {
        Line newBoondang = new Line(NEW_BOONDANG_LINE);
        for (String stationName : newBoondangLineStations) {
            newBoondang.addStationsInLine(StationRepository.getStationByName(stationName));
        }
        LineRepository.addLine(newBoondang);
    }
}

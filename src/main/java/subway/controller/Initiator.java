package subway.controller;

import subway.controller.constants.InitialNewBoonDangLine;
import subway.controller.constants.InitialSecondLine;
import subway.controller.constants.InitialStations;
import subway.controller.constants.InitialThirdLine;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Initiator {
    private static final String SECOND_LINE = "2호선";
    private static final String THIRD_LINE = "3호선";
    private static final String NEW_BOONDANG_LINE = "신분당선";

    public static void intiate() {
        initiateStation();
        initiateLine();
    }

    private static void initiateLine() {
        initiateSecondLine();
        initiateThirdLine();
        initiateNewBoonDangLine();
    }

    private static void initiateSecondLine() {
        Line secondLine = new Line(SECOND_LINE);
        for (InitialSecondLine eachStation : InitialSecondLine.values()) {
            int order = eachStation.getOrder();
            Station insertedStation = new Station(eachStation.getName());
            secondLine.insertStation(order, insertedStation);
        }
        LineRepository.addLine(secondLine);
    }

    private static void initiateThirdLine() {
        Line thirdLine = new Line(THIRD_LINE);
        for (InitialThirdLine eachStation : InitialThirdLine.values()) {
            int order = eachStation.getOrder();
            Station insertedStation = new Station(eachStation.getName());
            thirdLine.insertStation(order, insertedStation);
        }
        LineRepository.addLine(thirdLine);
    }

    private static void initiateNewBoonDangLine() {
        Line newBoonDangLine = new Line(NEW_BOONDANG_LINE);
        for (InitialNewBoonDangLine eachStation : InitialNewBoonDangLine.values()) {
            int order = eachStation.getOrder();
            Station insertedStation = new Station(eachStation.getName());
            newBoonDangLine.insertStation(order, insertedStation);
        }
        LineRepository.addLine(newBoonDangLine);
    }

    private static void initiateStation() {
        for (InitialStations initialStation : InitialStations.values()) {
            Station insertedStation = new Station(initialStation.getName());
            StationRepository.addStation(insertedStation);
        }
    }
}

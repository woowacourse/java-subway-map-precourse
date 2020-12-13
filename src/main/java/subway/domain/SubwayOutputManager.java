package subway.domain;

import subway.common.GuideMessage;
import subway.common.InfoMessage;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;

public class SubwayOutputManager {
    private static final String SUBWAY_MAP = "지하철노선도";
    private static final String DIVIDER = "---";

    private SubwayOutputManager() {
    }

    public static void printSubwayMap() {
        GuideMessage.print(SUBWAY_MAP);
        for (Line line : LineRepository.lines()) {
            InfoMessage.print(line.getName());
            InfoMessage.print(DIVIDER);
            for (Station station : SubwayRepository.getPathByLine(line).getPath()) {
                InfoMessage.print(station.getName());
            }
            System.out.println();
        }
    }


}

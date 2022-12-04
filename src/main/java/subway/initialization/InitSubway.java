package subway.initialization;

import java.util.Arrays;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.StationRepository;

public class InitSubway {

    public static void initSubway() {
        initLine();
        initStation();
        initSection();
    }

    private static void initSection() {
        Arrays.stream(InitSection.values())
                .forEach(section -> SectionRepository
                        .addSections(section.getInitLine(), section.getInitStation()));
    }

    private static void initStation() {
        Arrays.stream(InitStation.values())
                .forEach(station -> StationRepository
                        .addStation(station.getStationName()));
    }

    private static void initLine() {
        Arrays.stream(InitLine.values())
                .forEach(line -> LineRepository
                        .addLine(line.getLineName()));
    }
}

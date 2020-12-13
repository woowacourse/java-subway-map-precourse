package subway.domain.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sections {

    private final List<Station> stations;

    private Sections(List<Station> stations) {
        stations.forEach(Station::registerAsSection);
        this.stations = stations;
    }

    public static Sections of(Station upwardLastStation, Station downwardLastStation) {
        if (upwardLastStation.equals(downwardLastStation)) {
            throw new LastStationDuplicationException();
        }
        List<Station> stations = Stream.of(upwardLastStation, downwardLastStation)
                .collect(Collectors.toList());
        return new Sections(stations);
    }
}

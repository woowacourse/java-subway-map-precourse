package subway.domain;

import subway.util.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        int check = 0;
        for(Section section : SectionRepository.sections()) {
            for(Station station : section.getStation()) {
                if(station.getName().equals(name) && section.getStation().size() <= 2) {
                        check = 1;
                }
            }
        }
        if(check == 0) {
            SectionRepository.deleteSection(name);
            return stations.removeIf(station -> Objects.equals(station.getName(), name));
        } else {
            throw new IllegalArgumentException(Constants.STATION_REMOVE_FAIL);
        }
    }
}

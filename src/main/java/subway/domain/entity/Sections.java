package subway.domain.entity;

import subway.service.CannotFindStationException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sections {
    private static final int MINIMUM_SECTION_ORDER_NUMBER = 1;
    private static final int INDEX_ADJUSTMENT_NUMBER = 1;
    private static final int MINIMUM_SECTION_COUNTS = 2;

    private final List<Station> stations;

    private Sections(List<Station> stations) {
        stations.forEach(Station::registerAsLineSection);
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

    public void addSection(Station station, int sectionOrderNumber) {
        validateSectionRegistrationRequest(station, sectionOrderNumber);
        station.registerAsLineSection();
        stations.add(sectionOrderNumber - INDEX_ADJUSTMENT_NUMBER, station);
    }

    private void validateSectionRegistrationRequest(Station station, int sectionOrderNumber) {
        int maximumSectionOrderNumber = stations.size() + INDEX_ADJUSTMENT_NUMBER;
        if (sectionOrderNumber < MINIMUM_SECTION_ORDER_NUMBER || sectionOrderNumber > maximumSectionOrderNumber) {
            throw new InvalidSectionOrderException();
        }
        if (stations.contains(station)) {
            throw new SectionDuplicationException();
        }
    }

    public void deleteSectionByName(String stationName) {
        int sectionCounts = stations.size();
        if (sectionCounts <= MINIMUM_SECTION_COUNTS) {
            throw new CannotDeleteSectionException();
        }
        Station station = findStationByName(stationName);
        station.unregisterFromLineSection();
        stations.remove(station);
    }

    private Station findStationByName(String stationName) {
        return stations.stream()
                .filter(targetStation -> targetStation.matchesName(stationName))
                .findFirst()
                .orElseThrow(CannotFindStationException::new);
    }
}

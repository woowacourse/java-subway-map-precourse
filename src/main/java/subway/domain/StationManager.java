package subway.domain;


import java.util.List;

public class StationManager {
    public static final int MIN_NAME_LENGTH = 2;

    public static boolean validNameLength(String name) {
        return name.length() >= MIN_NAME_LENGTH;
    }

    public static boolean containsName(String name) {
        return StationRepository.stations().stream().anyMatch(station -> station.getName().equals(name));
    }

    public static boolean addStation(String name) {
        if (!validNameLength(name) || containsName(name)) {
            return false;
        }
        StationRepository.addStation(new Station(name));
        return true;
    }

    public static Station getByName(String name) {
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        return null;
    }

    public static boolean deleteStationByName(String name) {
        if (!containsName(name) || isBelongsToAnyLine(name)) {
            return false;
        }
        StationRepository.deleteStation(name);
        return true;
    }

    private static boolean isBelongsToAnyLine(String name) {
        return getByName(name).getBelongingLines().size() > 0;
    }

    public static List<Station> allStations() {
        return StationRepository.stations();
    }
}

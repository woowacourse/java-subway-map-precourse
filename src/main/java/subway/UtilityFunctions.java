package subway;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.message.ErrorMessage;

public class UtilityFunctions {

    private UtilityFunctions() {
    }

    public static List<Station> generateStationsByName(
        final String startStationName, final String endStationName
    ) throws IllegalArgumentException {
        List<Station> stations = new ArrayList<>();
        stations.add(getStationByNameFromRepository(startStationName));
        stations.add(getStationByNameFromRepository(endStationName));
        return stations;
    }

    private static void validateOptionalStation(Optional<Station> optionalStation) {
        if (optionalStation.isEmpty()) {
            throw new IllegalArgumentException(
                ErrorMessage.STATION_REPOSITORY_STATION_DOES_NOT_EXIST
                    .toString());
        }
    }

    public static Station getStationByNameFromRepository(final String stationName)
        throws IllegalArgumentException {
        final Optional<Station> optionalStation = StationRepository.getStationByName(stationName);
        validateOptionalStation(optionalStation);
        return optionalStation.get();
    }

    private static void validateOptionalLine(Optional<Line> optionalLine) {
        if (optionalLine.isEmpty()) {
            throw new IllegalArgumentException(
                ErrorMessage.LINE_REPOSITORY_LINE_DOES_NOT_EXIST.toString());
        }

    }

    public static Line getLineByNameFromRepository(final String lineName)
        throws IllegalArgumentException {
        final Optional<Line> optionalLine = LineRepository.getLineByName(lineName);
        validateOptionalLine(optionalLine);
        return optionalLine.get();
    }
}

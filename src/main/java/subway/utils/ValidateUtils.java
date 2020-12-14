package subway.utils;

import subway.domain.Line;
import subway.domain.Station;
import subway.exception.SubwayException;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.TextCollection;

import java.util.List;

public class ValidateUtils {
    private static int STANDARD_TWO = 2;

    public static void isTwoOrMoreLetters(String input) {
        if (input.length() < STANDARD_TWO) {
            throw new SubwayException(TextCollection.TWO_OR_MORE_LETTERS_MESSAGE);
        }
    }

    public static void isDuplicatedStation(String input) {
        if (StationRepository.stations().stream()
                .anyMatch(station -> station.getName().equals(input))) {
            throw new SubwayException(TextCollection.EXISTING_STATION_MESSAGE);
        }
    }

    public static void isDuplicatedLine(String input) {
        if (LineRepository.lines().stream()
                .anyMatch(line -> line.getName().equals(input))) {
            throw new SubwayException(TextCollection.EXISTING_LINE_MESSAGE);
        }
    }

    public static void isDuplicatedUpDownStation(Station upwardStation, Station downStation) {
        if (upwardStation.equals(downStation)) {
            throw new SubwayException(TextCollection.SAME_NAME_UP_DOWN_MESSAGE);
        }
    }

    public static void isAtLeastTwoStations(Line line) {
        if (line.getSections().size() <= STANDARD_TWO) {
            throw new SubwayException(TextCollection.AT_LEAST_STATIONS);
        }
    }

    public static void isNumber(String number) {
        String regExp = "^[0-9]+$";
        if (!number.matches(regExp)) {
            throw new SubwayException(TextCollection.NOT_NUMBER_MESSAGE);
        }
    }

    public static void isPositionOutOfLine(List<Station> section, int position) {
        if (section.size() < position) {
            throw new SubwayException(TextCollection.OUT_OF_LINE);
        }
    }
}

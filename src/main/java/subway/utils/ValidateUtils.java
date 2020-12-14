package subway.utils;

import subway.domain.Line;
import subway.domain.Station;
import subway.exception.SubwayException;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class ValidateUtils {
    private static int STANDARD_TWO = 2;
    private static final String TWO_OR_MORE_LETTERS_MESSAGE = "이름은 2글자 이상이어야 합니다.";
    private static final String EXISTING_STATION_MESSAGE = "이미 등록된 역 이름입니다.";
    private static final String EXISTING_LINE_MESSAGE = "이미 등록된 노선 이름입니다.";
    private static final String SAME_NAME_UP_DOWN_MESSAGE = "상행 종점역과 하행 종점역의 이름이 같습니다";

    public static void isTwoOrMoreLetters(String input) {
        if (input.length() < STANDARD_TWO) {
            throw new SubwayException(TWO_OR_MORE_LETTERS_MESSAGE);
        }
    }

    public static void isDuplicatedStation(String input) {
        if (StationRepository.stations().stream()
                .anyMatch(station -> station.getName().equals(input))) {
            throw new SubwayException(EXISTING_STATION_MESSAGE);
        }
    }


    public static void isDuplicatedLine(String input) {
        if (LineRepository.lines().stream()
                .anyMatch(line -> line.getName().equals(input))) {
            throw new SubwayException(EXISTING_LINE_MESSAGE);
        }
    }

    public static void isDuplicatedUpDownStation(Station upwardStation, Station downStation) {
        if (upwardStation.equals(downStation)) {
            throw new SubwayException(SAME_NAME_UP_DOWN_MESSAGE);
        }

    }
}

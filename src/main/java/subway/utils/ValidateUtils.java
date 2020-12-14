package subway.utils;

import subway.exception.SubwayException;
import subway.repository.StationRepository;

public class ValidateUtils {
    private static int STANDARD_TWO = 2;
    private static final String TWO_OR_MORE_LETTERS_MESSAGE = "지하철 역 이름은 2글자 이상이어야 합니다.";
    private static final String EXISTING_STATION_MESSAGE = "이미 등록된 역 입니다.";

    public static void isTwoOrMoreLetters(String input) {
        if (input.length() < STANDARD_TWO) {
            throw new SubwayException(TWO_OR_MORE_LETTERS_MESSAGE);
        }
    }

    public static void isDuplicatedStation(String input) {
        if (StationRepository.stations().stream()
            .anyMatch(station -> station.getName().equals(input))){
            throw new SubwayException(EXISTING_STATION_MESSAGE);
        }
    }
}

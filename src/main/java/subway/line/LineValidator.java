package subway.line;

import static subway.line.LineErrorMessage.DUPLICATE_STATION;
import static subway.line.LineErrorMessage.WRONG_NAME;

public class LineValidator {
    private static final int MIN_NAME_LENGTH = 2;

    public static void validateLineRequestDTO(LineRequestDTO lineRequestDTO){
        validateName(lineRequestDTO.getName());
        duplicateStation(lineRequestDTO.getStartStation(), lineRequestDTO.getEndStation());
    }

    private static void validateName(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalStateException(String.format(WRONG_NAME.getMessage(), MIN_NAME_LENGTH));
        }
    }

    private static void duplicateStation(String start, String end) {
        if(start.equals(end)){
            throw new IllegalStateException(DUPLICATE_STATION.getMessage());
        }
    }
}

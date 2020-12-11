package subway.station;

import static subway.station.StationErrorMessage.*;

public class StationValidator {
    private static final int MIN_NAME_LENGTH = 2;

    public static void validateName(String name){
        if(name.length() < MIN_NAME_LENGTH){
            throw new IllegalStateException(String.format(WRONG_NAME.getMessage(), MIN_NAME_LENGTH));
        }
    }
}

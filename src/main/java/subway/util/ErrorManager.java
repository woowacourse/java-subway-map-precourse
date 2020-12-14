package subway.util;

import subway.domain.Station;
import subway.domain.StationRepository;

public class ErrorManager {
    public static void checkInput(String input) {
        if(input != "Q" || input != "1" || input != "2" || input != "3" || input != "4") {
            throw new IllegalArgumentException(Constants.COMMAND_FAIL);
        }
    }

    public static void checkNameLength(String input) {
        if(input.length() < 2) {
            throw new IllegalArgumentException("[Error] 이름은 2글자 이상이어야 합니다.");
        }
    }

    public static void isStationExist(String input) {
        int check = 0;
        for(Station station : StationRepository.stations()) {
            if(station.getName() == input) {
                check = 1;
            }
        }
        if(check == 0) {
            throw new IllegalArgumentException();
        }
    }

}

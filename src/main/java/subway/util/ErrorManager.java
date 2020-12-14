package subway.util;

import subway.domain.Station;
import subway.domain.StationRepository;

public class ErrorManager {
    public static IllegalArgumentException checkInput(String input) {
        if(input != "Q" || input != "1" || input != "2" || input != "3" || input != "4") {
            return new IllegalArgumentException("[Error] 선택할 수 없는 기능입니다.");
        }
        return null;
    }

    public static IllegalArgumentException checkNameLength(String input) {
        if(input.length() < 2) {
            return new IllegalArgumentException("[Error] 이름은 2글자 이상이어야 합니다.");
        }
        return null;
    }

    public static IllegalArgumentException isStationExist(String input) {
        int check = 0;
        for(Station station : StationRepository.stations()) {
            if(station.getName() == input) {
                check = 1;
            }
        }
        if(check == 0) {
            return new IllegalArgumentException();
        }
        return null;
    }

}

package subway.util;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class ErrorManager {
    public static void checkInput(String input) {
        if(input.equals("Q")) {

        } else if(input.equals("1")) {

        } else if(input.equals("2")) {

        } else if(input.equals("3")) {

        } else if(input.equals("4")) {

        } else {
            throw new IllegalArgumentException(Constants.COMMAND_FAIL);
        }
    }

    public static void checkNameLength(String input) {
        if(input.length() < 2) {
            throw new IllegalArgumentException(Constants.NAME_LENGTH_FAIL);
        }
    }

    public static boolean isStationExist(String input) {
        boolean check = false;
        for(Station station : StationRepository.stations()) {
            if(station.getName().equals(input)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static boolean isLineExist(String input) {
        boolean check = false;
        for(Line line : LineRepository.lines()) {
            if(line.getName().equals(input)) {
                check = true;
                break;
            }
        }
        return check;
    }

}

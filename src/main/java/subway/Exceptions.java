package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

public class Exceptions {
    public static String checkStationAdd(String input) {
        input = isStation(input);
        input = isLengthTwoOrMore(input);
        input = isNotInStationList(input);
        return input;
    }

    public static String checkStationDelete(String input) {
        input = isInStationList(input);
        input = isNotInLine(input);
        return input;
    }

    public static String checkLineNameAdd(String input) {
        input = isLengthTwoOrMore(input);
        input = isNotInLineList(input);
        return input;
    }

    public static String checkLastStation(String input, String firstStation) {
        input = isInStationList(input);
        if (input.equals(firstStation)) {
            throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.FIRST_STATION_CANNOT_BE_LAST_STATION);
        }
        return input;
    }

    static String isInMenu(String input, List<String> menuItemList) {
        for (int i = 0; i < menuItemList.size(); i++) {
            String number = menuItemList.get(i).substring(0, 1);
            if (input.equals(number)) {
                return input;
            }
        }
        throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.IS_IN_MENU);
    }

    static String isStation(String input) {
        String lastChar = input.substring(input.length() - 1, input.length());
        if (lastChar.equals(Constant.STATION)) {
            return input;
        }
        throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.IS_STATION);
    }

    static String isLengthTwoOrMore(String input) {
        if (input.length() >= 2) {
            return input;
        }
        throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.IS_LENGTH_TWO_OR_MORE);
    }

    static String isNotInStationList(String name) {
        if (!StationRepository.has(name)) {
            return name;
        }
        throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.IS_NOT_IN_STATION_LIST);
    }

    static String isInStationList(String name) {
        if (StationRepository.has(name)) {
            return name;
        }
        throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.IS_IN_STATION_LIST);
    }

    static String isNotInLineList(String name) {
        if (!LineRepository.has(name)) {
            return name;
        }
        throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.IS_NOT_IN_LINE_LIST);
    }

    static String isInLineList(String name) {
        if (LineRepository.has(name)) {
            return name;
        }
        throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.IS_IN_LINE_LIST);
    }

    static String isNotInLine(String name) {
        LineRepository.lines().forEach(line -> {
            line.stations().forEach(station -> {
                isStationNameSame(station, name);
            });
        });
        return name;
    }

    static void isStationNameSame(Station station, String name) {
        if (station.getName().equals(name)) {
            throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.IS_IN_LINE);
        }
    }

    static String isInThisLine(String stationName, Line line) {
        line.stations().forEach(station -> {
            if (station.getName().equals(stationName)) {
                throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.IS_IN_THIS_LINE);
            }
        });
        return stationName;
    }

    static void isNotInThisLine() {
        throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.IS_NOT_IN_THIS_LINE);
    }

    static int checkOrderInput(String inputString, int stationsSize) {
        int input = isInteger(inputString);
        input = isValidRange(input, stationsSize);
        return isNaturalNumber(input);
    }

    static int isInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.IS_NATURAL_NUMBER);
        }
    }

    static int isNaturalNumber(int input) {
        if (input > 0) {
            return input;
        }
        throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.IS_NATURAL_NUMBER);
    }

    static int isValidRange(int input, int stationsSize) {
        if (input <= stationsSize) {
            return input;
        }
        throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.IS_VALID_RANGE);
    }


}

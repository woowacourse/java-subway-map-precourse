package subway;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

public class Exception {
    public static String checkMenu(String input, List<String> menuItemList) {
        input = isNotEmpty(input);
        input = isNotSpace(input);
        input = isInMenu(input, menuItemList);
        return input;
    }

    public static String checkStationAdd(String input) {
        input = isNotEmpty(input);
        input = isNotSpace(input);
        input = isStation(input);
        input = isLengthTwoOrMore(input);
        input = isNotInStationList(input);
        return input;
    }

    static String isNotEmpty(String input) {
        if (!input.equals("")) {
            return input;
        }
        throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.IS_NOT_EMPTY);
    }

    static String isNotSpace(String input) {
        if (!input.contains(" ")) {
            return input;
        }
        throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.IS_NOT_SPACE);
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
}

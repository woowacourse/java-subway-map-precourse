package subway.tool;

import subway.domain.LineRepository;
import subway.domain.Station;

public class InputTool {
    public static boolean isMainInputVaild(String input) {
        if (input.compareTo("1") == 0) return true;
        if (input.compareTo("2") == 0) return true;
        if (input.compareTo("3") == 0) return true;
        if (input.compareTo("4") == 0) return true;
        if (input.compareTo("Q") == 0) return true;
        return false;
    }

    public static boolean isStationAndLineInputVaild(String input) {
        if (input.compareTo("1") == 0) return true;
        if (input.compareTo("2") == 0) return true;
        if (input.compareTo("3") == 0) return true;
        if (input.compareTo("B") == 0) return true;
        return false;
    }

    public static boolean isValidName(String name) {
        final int MIN_NAME_LENGTH = 2;
        if (name.length() < MIN_NAME_LENGTH) return false;
        return true;
    }

    public static boolean isSectionInputVaild(String input) {
        if (input.compareTo("1") == 0) return true;
        if (input.compareTo("2") == 0) return true;
        if (input.compareTo("B") == 0) return true;
        return false;
    }

    public static boolean isPossibleInsertLineSize(String lineName, String input) {
        final int lineSize = LineRepository.getTargetLineSize(lineName);
        if (lineSize >= Integer.parseInt(input)) return true;
        return false;
    }

    public static boolean isPossibleDeleteLineSize(String lineName) {
        final int lineSize = LineRepository.getTargetLineSize(lineName);
        if (lineSize <=2) return false;
        return true;
    }

    public static boolean isNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            char check = input.charAt(i);
            if (check < 48 || check > 58) {
                return false;
            }
        }
        return true;
    }
}

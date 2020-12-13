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
        System.out.println(lineSize);
        //역이 3개면 4번째에 추가할 수 있음
        if(lineSize+1>=Integer.parseInt(input)) return true;
        return false;
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

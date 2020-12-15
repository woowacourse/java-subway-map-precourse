package subway.utils;

import subway.view.ErrorView;

public class Util {

    private final static String QUIT = "Q";
    private final static String BACK = "B";
    private final static int BACK_NUMBER = 0;
    private final static int ERROR = -1;

    public static int operationNumber(String number, int start, int end) {
        if (number.equals(QUIT) || number.equals(BACK)) {
            return BACK_NUMBER;
        }
        if (!isNumber(number)) {
            ErrorView.writeAppropriateNumber();
            return ERROR;
        }
        int operationNumber = Integer.parseInt(number);
        if (operationNumber < start || operationNumber > end) {
            ErrorView.writeAppropriateNumber();
            return ERROR;
        }
        return operationNumber;
    }

    public static boolean isNumber(String number) {
        int length = number.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

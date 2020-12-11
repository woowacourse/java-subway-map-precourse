package subway.domain.station;

import subway.view.OutputView;

public class Station {
    public static final int MIN_NAME_LENGTH = 2;

    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void validateName(String name) {
        validateLength(name);
        validateEnding(name);
    }

    private static void validateLength(String name) {
        if(shorterThanMinimalLength(name)) {
            throw new IllegalArgumentException(OutputView.ERROR_NAME_SHORT);
        }
    }

    private static boolean shorterThanMinimalLength(String name) {
        return name.length() < MIN_NAME_LENGTH;
    }

    private static void validateEnding(String name) {
//        if(notDesiredEnding(name)) {
//            throw new IllegalArgumentException();
//        }
    }

}

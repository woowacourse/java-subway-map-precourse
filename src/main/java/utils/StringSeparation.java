package utils;

import java.util.stream.Stream;

public class StringSeparation {
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final String EMPTY = "";

    public static String[] stringToArray(String string) {
        return Stream.of(string.split(COMMA))
                .map(s -> s.replaceAll(BLANK, EMPTY))
                .toArray(String[]::new);
    }
}

package subway.station.validation;

public class CheckLastLetter {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String WRONG_LAST_LETTER = ERROR_PREFIX + "역 이름은 '역'으로 끝나야 합니다.";
    private static final char LAST_LETTER = '역';

    public static void validation(String name) {
        int lastIndex = name.length() - 1;
        char lastLetter = name.charAt(lastIndex);

        if (lastLetter != LAST_LETTER) {
            throw new IllegalArgumentException(WRONG_LAST_LETTER);
        }
    }
}

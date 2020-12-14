package subway.domain.list;

public class LineCheck {

    private String lineName;

    private static final int MIN_LINE_NAME_LENGTH = 2;

    private static final String LINE_LENGTH_ERROR_MESSAGE = "[ERROR] 노선 이름은 2글자 이상 입력해야합니다.";

    public static boolean checkLineNameLength(String lineName) {
        if (lineName.length() < MIN_LINE_NAME_LENGTH) {
            throw new IllegalArgumentException(LINE_LENGTH_ERROR_MESSAGE);
        }
        return true;
    }
}

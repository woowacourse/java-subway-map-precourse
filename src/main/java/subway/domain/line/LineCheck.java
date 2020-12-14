package subway.domain.line;

public class LineCheck {

    private static final int MIN_LINE_NAME_LENGTH = 2;

    private static final String LINE_LENGTH_ERROR_MESSAGE = "[ERROR] 노선 이름은 2글자 이상 입력해야합니다.";
    public static final String LINE_END_POINT_ERROR_MESSAGE = "[ERROR] 노선이름은 OO선 또는 O호선으로 끝나야 합니다.";

    public static boolean checkLineNameLength(String lineName) {
        if (lineName.length() < MIN_LINE_NAME_LENGTH) {
            throw new IllegalArgumentException(LINE_LENGTH_ERROR_MESSAGE);
        }
        return true;
    }

    public static boolean checkLineNameEndPoint(String lineName) {
        if (!lineName.endsWith("선") || !lineName.endsWith("호선")) {
            throw new IllegalArgumentException(LINE_END_POINT_ERROR_MESSAGE);
        }
        return true;
    }
}

package subway.line.validation;

import subway.line.Line;

public class CheckNotExistStation {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NOT_EXIST = ERROR_PREFIX + "해당 노선에 존재하지 않는 역입니다.";

    public static void validation(Line line, String name) {
        if (!line.isRegistered(name)) {
            throw new IllegalArgumentException(NOT_EXIST);
        }
    }
}

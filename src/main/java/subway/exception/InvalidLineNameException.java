package subway.exception;

import subway.domain.name.LineName;

public class InvalidLineNameException extends RuntimeException {

    private static final String ERROR_MESSAGE = "[ERRPR] 유요하지 않는 노선 이름입니다.INPUT: %s";

    public InvalidLineNameException(String name) {
        super(String.format(ERROR_MESSAGE, name));
    }

    public InvalidLineNameException(LineName lineName) {
        super(String.format(ERROR_MESSAGE, lineName.toString()));
    }
}

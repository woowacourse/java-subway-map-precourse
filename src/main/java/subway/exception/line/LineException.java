package subway.exception.line;

import subway.exception.CustomException;

public abstract class LineException extends CustomException {
    private final String HEADER = "노선 오류 - ";

    public String getHeader() {
        return HEADER;
    }

    abstract public void printError();
}

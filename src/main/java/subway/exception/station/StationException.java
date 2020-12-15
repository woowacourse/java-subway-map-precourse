package subway.exception.station;

import subway.exception.CustomException;

public abstract class StationException extends CustomException {

    private final String HEADER = "역 오류 - ";

    public String getHeader() {
        return HEADER;
    }

    abstract public void printError();
}

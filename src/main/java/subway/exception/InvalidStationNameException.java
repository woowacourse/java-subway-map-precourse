package subway.exception;

public class InvalidStationNameException extends RuntimeException {

    private static final String ERROR_MESSAGE = "[ERROR] 유요하지 않는 역이름입니다. INPUT: %s";

    public InvalidStationNameException(String name) {
        super(String.format(ERROR_MESSAGE, name));
    }
}

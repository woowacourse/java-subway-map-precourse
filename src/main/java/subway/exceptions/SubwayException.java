package subway.exceptions;

import java.util.function.Supplier;

public class SubwayException extends Exception {
    private final String ERROR_MESSAGE = "[ERROR] ";

    public SubwayException(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
}

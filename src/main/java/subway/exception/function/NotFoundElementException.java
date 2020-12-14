package subway.exception.function;

public class NotFoundElementException extends FunctionException {

    public static final String NOT_FOUND_ERROR = "%s은 존재하지 않습니다.";

    public NotFoundElementException(String name) {
        super(String.format(NOT_FOUND_ERROR, name));
    }
}

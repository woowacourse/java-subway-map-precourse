package subway.exception;

public class AlreadyExistsException extends FunctionException {

    public static final String ALREADY_EXISTS_ERROR = "%s은 이미 존재하는 %s 이름입니다!";

    public AlreadyExistsException(String name, String type) {
        super(String.format(ALREADY_EXISTS_ERROR, name, type));
    }
}

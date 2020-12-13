package exception;

public class NameLengthException extends RuntimeException {
    private final static String ERROR = "[ERROR] ";
    private final static String CAUSE = "이름은 역을 포함하여 3글자 이상으로 입력해주세요.";

    public NameLengthException() {
        super(ERROR + CAUSE);
    }
}


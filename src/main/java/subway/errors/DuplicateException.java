package subway.errors;

public class DuplicateException extends RuntimeException {

    public DuplicateException(String message) {
        super("이미 등록된 " + message + "입니다.");
    }
}

package subway.exception;

public class WrongSequenceNumberException extends SubwayException {


    public WrongSequenceNumberException() {
    }

    @Override
    public String getMessage() {
        return ERROR + " 올바르지 않은 순서입니다.";
    }
}

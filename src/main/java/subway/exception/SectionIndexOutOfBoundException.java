package subway.exception;

public class SectionIndexOutOfBoundException extends SubwayException {

    public SectionIndexOutOfBoundException() {
        super();
    }

    @Override
    public String getMessage() {
        return ERROR + " 순서가 범위에 맞지 않습니다.";
    }
}

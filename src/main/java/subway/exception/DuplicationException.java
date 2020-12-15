package subway.exception;

public class DuplicationException extends SubwayException {

    protected Object obj;

    public DuplicationException(Object obj) {
        this.obj = obj;
    }

    @Override
    public String getMessage() {
        return ERROR + " " + obj.toString() + "이 중복됩니다.";
    }
}

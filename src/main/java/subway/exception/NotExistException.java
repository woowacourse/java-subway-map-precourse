package subway.exception;

public class NotExistException extends SubwayException {

    protected Object obj;

    public NotExistException(Object obj) {
        this.obj = obj;
    }

    @Override
    public String getMessage() {
        return ERROR + " " + obj.toString() + "이 존재하지 않습니다.";
    }
}

package subway.exception;

public class LineDuplicationException extends DuplicationException {

    public LineDuplicationException(Object obj) {
        super(obj);
    }

    @Override
    public String getMessage() {
        return ERROR + " " + obj.toString() + "은 이미 등록된 노선입니다.";
    }
}

package subway.exception;

public class LineMinimumNameLengthException extends MinimumNameLengthException {

    public LineMinimumNameLengthException(int MINIMUM_LENGTH) {
        super(MINIMUM_LENGTH);
    }

    @Override
    public String getMessage() {
        return ERROR + "노선 이름은 최소 " + MINIMUM_LENGTH + "글자 이상이어야 합니다.";
    }
}

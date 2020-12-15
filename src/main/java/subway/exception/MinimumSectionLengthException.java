package subway.exception;

public class MinimumSectionLengthException extends MinimumLengthException {


    public MinimumSectionLengthException(int MINIMUM_LENGTH) {
        super(MINIMUM_LENGTH);
    }

    @Override
    public String getMessage() {
        return ERROR + " 구간의 길이는 최소 " + MINIMUM_LENGTH + "이어야 합니다.";
    }
}

package subway.exception;

public class MinimumLengthException extends SubwayException {

    protected final int MINIMUM_LENGTH;

    public MinimumLengthException(int MINIMUM_LENGTH) {
        this.MINIMUM_LENGTH = MINIMUM_LENGTH;
    }


}

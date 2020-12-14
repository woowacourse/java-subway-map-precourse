package subway.domain.exception;

import subway.view.outputview.ErrorOutputView;

public class InvalidOrderLengthException extends RuntimeException {
    public InvalidOrderLengthException() {
        ErrorOutputView.invalidOrderRange();
    }
}

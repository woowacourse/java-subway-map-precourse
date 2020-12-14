package subway.domain.exception;

import subway.view.outputview.ErrorOutputView;

public class InvalidOrderException extends RuntimeException {
    public InvalidOrderException() {
        ErrorOutputView.invalidOrderNumber();
    }
}

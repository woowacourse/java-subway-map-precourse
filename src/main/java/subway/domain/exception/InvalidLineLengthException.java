package subway.domain.exception;

import subway.view.outputview.ErrorOutputView;

public class InvalidLineLengthException extends RuntimeException {
    public InvalidLineLengthException() {
        ErrorOutputView.invalidLineLength();
    }
}

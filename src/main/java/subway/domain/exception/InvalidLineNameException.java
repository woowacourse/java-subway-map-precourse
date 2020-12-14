package subway.domain.exception;

import subway.view.outputview.ErrorOutputView;

public class InvalidLineNameException extends RuntimeException {
    public InvalidLineNameException() {
        ErrorOutputView.invalidLineName();
    }
}

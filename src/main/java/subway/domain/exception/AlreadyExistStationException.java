package subway.domain.exception;

import subway.view.outputview.ErrorOutputView;

public class AlreadyExistStationException extends RuntimeException {
    public AlreadyExistStationException() {
        ErrorOutputView.existStation();
    }
}

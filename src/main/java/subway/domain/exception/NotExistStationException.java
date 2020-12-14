package subway.domain.exception;

import subway.view.outputview.ErrorOutputView;

public class NotExistStationException extends RuntimeException {
    public NotExistStationException() {
        ErrorOutputView.notExistStation();
    }
}

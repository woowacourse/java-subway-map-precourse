package subway.domain.exception;

import subway.view.outputview.ErrorOutputView;

public class DuplicateFirstLastStationException extends RuntimeException {
    public DuplicateFirstLastStationException() {
        ErrorOutputView.equalFirstAndLastStation();
    }
}

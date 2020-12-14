package subway.domain.exception;

import subway.view.outputview.ErrorOutputView;

public class InvalidStationNameException extends RuntimeException {
    public InvalidStationNameException() {
        ErrorOutputView.invalidStationName();
    }
}

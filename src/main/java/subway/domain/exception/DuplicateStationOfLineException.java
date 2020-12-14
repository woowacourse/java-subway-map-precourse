package subway.domain.exception;

import subway.view.outputview.ErrorOutputView;

public class DuplicateStationOfLineException extends RuntimeException {
    public DuplicateStationOfLineException() {
        ErrorOutputView.notStationInLine();
    }
}

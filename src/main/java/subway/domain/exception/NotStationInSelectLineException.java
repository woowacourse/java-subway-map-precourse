package subway.domain.exception;

import subway.view.outputview.ErrorOutputView;

public class NotStationInSelectLineException extends RuntimeException {
    public NotStationInSelectLineException() {
        ErrorOutputView.notStationInSelectLine();
    }
}

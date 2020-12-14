package subway.domain.exception;

import subway.view.outputview.ErrorOutputView;

public class NotExistLineException extends RuntimeException {
    public NotExistLineException() {
        ErrorOutputView.notExistLine();
    }
}

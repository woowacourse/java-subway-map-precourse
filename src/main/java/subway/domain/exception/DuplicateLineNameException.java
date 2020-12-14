package subway.domain.exception;

import subway.view.outputview.ErrorOutputView;

public class DuplicateLineNameException extends RuntimeException {
    public DuplicateLineNameException() {
        ErrorOutputView.existLine();
    }
}

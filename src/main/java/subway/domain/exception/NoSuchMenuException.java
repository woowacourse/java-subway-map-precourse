package subway.domain.exception;

import subway.view.outputview.ErrorOutputView;

public class NoSuchMenuException extends RuntimeException {
    public NoSuchMenuException() {
        ErrorOutputView.invalidMenu();
    }
}

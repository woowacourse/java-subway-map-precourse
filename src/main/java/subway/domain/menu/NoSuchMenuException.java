package subway.domain.menu;

import subway.view.outputview.ErrorOutputView;

public class NoSuchMenuException extends RuntimeException {
    public NoSuchMenuException() {
        ErrorOutputView.invalidMenu();
    }
}

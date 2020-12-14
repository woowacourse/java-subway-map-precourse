package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class InvalidPositionException extends IllegalArgumentException {
    public InvalidPositionException() {
        super(ErrorViewComponent.getInvalidPosition() +
                CommonViewComponent.getWhiteLine());
    }
}

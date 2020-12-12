package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class InvalidPositionException extends Exception {
    public InvalidPositionException() {
        super(ErrorViewComponent.getInvalidPositionComponent() +
                CommonViewComponent.getWhiteLineComponent());
    }
}

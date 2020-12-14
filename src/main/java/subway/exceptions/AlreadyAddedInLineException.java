package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class AlreadyAddedInLineException extends IllegalArgumentException {
    public AlreadyAddedInLineException() {
        super(ErrorViewComponent.getAlreadyAddedInLine() +
                CommonViewComponent.getWhiteLine());
    }
}

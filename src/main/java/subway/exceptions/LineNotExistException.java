package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class LineNotExistException extends IllegalArgumentException {
    public LineNotExistException() {
        super(ErrorViewComponent.getLineNotExist() +
                CommonViewComponent.getWhiteLine());
    }
}

package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class LineNotExistException extends Exception {
    public LineNotExistException() {
        super(ErrorViewComponent.getLineNotExistComponent() +
                CommonViewComponent.getWhiteLineComponent());
    }
}

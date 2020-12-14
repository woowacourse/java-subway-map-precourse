package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class StationNotExistInLineException extends IllegalArgumentException {
    public StationNotExistInLineException() {
        super(ErrorViewComponent.getStationNotExistInLine() +
                CommonViewComponent.getWhiteLine());
    }
}
package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class StationNotExistException extends IllegalArgumentException {
    public StationNotExistException() {
        super(ErrorViewComponent.getStationNotExisted() +
                CommonViewComponent.getWhiteLine());
    }
}
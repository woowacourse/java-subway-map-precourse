package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class StationNameLengthException extends IllegalArgumentException {
    public StationNameLengthException() {
        super(ErrorViewComponent.getStationNameLength() +
                CommonViewComponent.getWhiteLine());
    }
}

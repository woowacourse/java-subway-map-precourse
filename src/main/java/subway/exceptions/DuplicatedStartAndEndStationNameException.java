package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class DuplicatedStartAndEndStationNameException extends IllegalArgumentException {
    public DuplicatedStartAndEndStationNameException() {
        super(ErrorViewComponent.getDuplicatedStartAndEndStationName() +
                CommonViewComponent.getWhiteLine());
    }
}
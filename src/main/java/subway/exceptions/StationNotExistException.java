package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class StationNotExistException  extends Exception {
    public StationNotExistException() {
        super(ErrorViewComponent.getStationNotExistComponent() +
                CommonViewComponent.getWhiteLineComponent());
    }
}
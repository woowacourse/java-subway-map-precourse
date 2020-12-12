package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class StationNameLengthException extends Exception{
    public StationNameLengthException(){
        super(ErrorViewComponent.getStationNameLengthComponent() +
                CommonViewComponent.getWhiteLineComponent());
    }
}

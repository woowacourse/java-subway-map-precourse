package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class DuplicatedStationNameException extends IllegalArgumentException{
    public DuplicatedStationNameException(){
        super(ErrorViewComponent.getDuplicatedStationNameLog() +
                CommonViewComponent.getWhiteLineComponent());
    }
}

package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class DuplicatedStartAndEndStationNameException extends Exception{
    public DuplicatedStartAndEndStationNameException(){
        super(ErrorViewComponent.getDuplicatedStartAndEndStationName() +
                CommonViewComponent.getWhiteLineComponent());
    }
}
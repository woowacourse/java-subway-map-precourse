package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class DuplicatedLineNameException  extends Exception{
    public DuplicatedLineNameException(){
        super(ErrorViewComponent.getDuplicatedStationNameComponent() +
                CommonViewComponent.getWhiteLineComponent());
    }
}

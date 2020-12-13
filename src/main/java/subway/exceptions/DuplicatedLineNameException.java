package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class DuplicatedLineNameException  extends IllegalArgumentException{
    public DuplicatedLineNameException(){
        super(ErrorViewComponent.getDuplicatedStationNameComponent() +
                CommonViewComponent.getWhiteLineComponent());
    }
}

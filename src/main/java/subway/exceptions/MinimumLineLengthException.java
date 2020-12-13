package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class MinimumLineLengthException extends IllegalArgumentException{
    public MinimumLineLengthException(){
        super(ErrorViewComponent.getMinimumLineLengthComponent() +
                CommonViewComponent.getWhiteLineComponent());
    }
}
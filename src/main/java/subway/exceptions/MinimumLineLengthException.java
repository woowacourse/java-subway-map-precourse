package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class MinimumLineLengthException extends Exception{
    public MinimumLineLengthException(){
        super(ErrorViewComponent.getMinimumLineLengthComponent() +
                CommonViewComponent.getWhiteLineComponent());
    }
}
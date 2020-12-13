package subway.exceptions;

import subway.view.component.CommonViewComponent;
import subway.view.component.ErrorViewComponent;

public class UnselectableFeatureException extends IllegalArgumentException{
    public UnselectableFeatureException(){
        super(ErrorViewComponent.getUnselectableFeatureComponent() +
                CommonViewComponent.getWhiteLineComponent());
    }
}

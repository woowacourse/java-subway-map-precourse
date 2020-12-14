package subway.view.input;

import subway.view.component.CommonViewComponent;
import subway.view.component.common.InputViewComponent;
import subway.view.component.common.OutputViewComponent;

public class CommonInputView {
    public static String getMenuInputLog(){
        System.out.println(CommonViewComponent.getSelectFeatureViewComponent());
        String menuInput = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return menuInput;
    }
}

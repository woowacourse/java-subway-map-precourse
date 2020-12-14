package subway;

import subway.view.OutputMessage;
import subway.domain.Line;

public class ControlLine {

    public static void manageLine(){
        OutputMessage.manageLineMessage();
        LineFunctionChoice choice=LineFunctionChoice.lineFunctionInput();
        choice.doingFunction(choice.getChoiceKey());
    }
}

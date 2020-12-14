package subway;

import subway.view.OutputMessage;
import subway.domain.Line;

public class LineCompute {

    public static void manageLine(){
        OutputMessage.manageLineMessage();
        String tmpSaveFunctionNumber=OutputMessage.choiceOutputMessage();
        if(!LineFunctionChoice.checkInput(tmpSaveFunctionNumber)){
            OutputMessage.setErrorMessageFunctionChoice();
            System.out.println();
            manageLine();
        }
        LineFunctionChoice choice=LineFunctionChoice.lineFunctionInput(tmpSaveFunctionNumber);
        if(!choice.doingFunction()){

            manageLine();

        }
        System.out.println();
    }
}

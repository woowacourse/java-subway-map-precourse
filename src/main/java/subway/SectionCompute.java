package subway;

import subway.view.OutputMessage;

public class SectionCompute {
    public static void manageSection(){
        OutputMessage.sectionOutputMessage();
        String tmpSaveFunctionKey=OutputMessage.choiceOutputMessage();
        if(!SectionFunctionChoice.checkInput(tmpSaveFunctionKey)){
            System.out.println();
            manageSection();
        }
        SectionFunctionChoice choice=SectionFunctionChoice.sectionFunctionInput(tmpSaveFunctionKey);
        if(!choice.doingFunction()){
            System.out.println();
            manageSection();
        }
    }

}

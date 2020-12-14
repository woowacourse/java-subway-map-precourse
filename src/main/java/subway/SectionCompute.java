package subway;

import subway.view.OutputMessage;

public class SectionCompute {
    static String tmpSaveFunctionKey;
    public static void manageSection(){
        OutputMessage.sectionOutputMessage();
        tmpSaveFunctionKey=OutputMessage.choiceOutputMessage();
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

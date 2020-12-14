package subway;

import subway.view.OutputMessage;

public class SectionCompute {
    public static void manageSection(){
        OutputMessage.sectionOutputMessage();
        SectionFunctionChoice choice=SectionFunctionChoice.sectionFunctionInput();
        choice.doingFunction(choice.getChoiceKey());
    }

}

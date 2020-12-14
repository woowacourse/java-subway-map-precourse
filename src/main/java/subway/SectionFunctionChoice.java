package subway;

import subway.view.OutputMessage;

import java.util.Arrays;
import java.util.function.Consumer;

public enum SectionFunctionChoice {
    ADD_SECTION("1",(choiceKey)->Section.registerSection());

    String choiceKey;
    Consumer<String> handlerFunction;

    SectionFunctionChoice(String choiceKey,Consumer<String> handlerFunction){
        this.choiceKey=choiceKey;
        this.handlerFunction=handlerFunction;
    }
    public void doingFunction(String name){
        handlerFunction.accept(name);
    }
    public String getChoiceKey(){
        return choiceKey;
    }
    public static SectionFunctionChoice sectionFunctionDecide(String choiceKey){
        return Arrays.stream(values()).filter(value -> value.choiceKey.equals(choiceKey)).findFirst().get();
    }
    public static boolean checkInput(String choiceKey){
        return Arrays.stream(values()).anyMatch(value->value.choiceKey.equals(choiceKey));
    }
    public static SectionFunctionChoice sectionFunctionInput(){
        String tmpSaveChoiceNumber= OutputMessage.choiceOutputMessage();
        if(checkInput(tmpSaveChoiceNumber)){
            return sectionFunctionDecide(tmpSaveChoiceNumber);
        }
        return sectionFunctionInput();
    }
}

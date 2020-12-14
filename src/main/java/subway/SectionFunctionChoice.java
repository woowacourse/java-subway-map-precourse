package subway;

import subway.view.OutputMessage;
import sun.text.resources.uk.JavaTimeSupplementary_uk;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

public enum SectionFunctionChoice {
    ADD_SECTION("1",()->Section.registerSection()),
    DELETE_SECTION("2",()->Section.deleteSection());
    //BACK("B",);
    String choiceKey;
    Supplier<Boolean> handlerFunction;

    SectionFunctionChoice(String choiceKey,Supplier<Boolean> handlerFunction){
        this.choiceKey=choiceKey;
        this.handlerFunction=handlerFunction;
    }
    public boolean doingFunction(){
        return handlerFunction.get();
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
    public static SectionFunctionChoice sectionFunctionInput(String tmpFunctionKey){
        return sectionFunctionDecide(tmpFunctionKey);
    }
}

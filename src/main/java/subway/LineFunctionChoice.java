package subway;

import subway.domain.LineRepository;
import subway.view.OutputMessage;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

import subway.domain.Line;

import javax.xml.bind.SchemaOutputResolver;

public enum LineFunctionChoice {
    ADD_LINE("1", ()->ControlLine.addLine()),
    DELETE_LINE("2", ()->ControlLine.deleteLine()),
    LOOK_LINE("3",()->ControlLine.lookLine()),
    BACK("B",()->ControlLine.lineBack());
    private String choiceKey;
    private Supplier<Boolean> handlerFunction;
    LineFunctionChoice(String choiceKey,Supplier<Boolean> handlerFunction){
        this.choiceKey=choiceKey;
        this.handlerFunction=handlerFunction;
    }
    public boolean doingFunction(){
        return handlerFunction.get();
    }
    public String getChoiceKey(){
        return choiceKey;
    }
    public static LineFunctionChoice lineFunctionDecide(String choiceKey){
        return Arrays.stream(values()).filter(value -> value.choiceKey.equals(choiceKey)).findFirst().get();
    }
    public static boolean checkInput(String choiceKey){
        return Arrays.stream(values()).anyMatch(value->value.choiceKey.equals(choiceKey));
    }
    public static LineFunctionChoice lineFunctionInput(String inputNumber){
        return lineFunctionDecide(inputNumber);
    }
}

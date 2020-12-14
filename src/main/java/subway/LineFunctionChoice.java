package subway;

import subway.domain.LineRepository;
import subway.view.OutputMessage;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

import subway.domain.Line;

import javax.xml.bind.SchemaOutputResolver;

public enum LineFunctionChoice {
    ADD_LINE("1", ()->LineRepository.addLine(new Line(OutputMessage.registerLineName(),OutputMessage.registerLineUpStation()))),
    DELETE_LINE("2", ()->LineRepository.deleteLineByName(OutputMessage.deleteLineName())),
    LOOK_LINE("3",()->LineRepository.back()),
    BACK("B",()->LineRepository.back());
    private String choiceKey;
    private Supplier<Boolean> handlerFunction;
    LineFunctionChoice(String choiceKey,Supplier<Boolean> handlerFunction){
        this.choiceKey=choiceKey;
        this.handlerFunction=handlerFunction;
    }
    public void doingFunction(){
        handlerFunction.get();
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
    public static LineFunctionChoice lineFunctionInput(){
        String tmpSaveChoiceNumber= OutputMessage.choiceOutputMessage();
        if(checkInput(tmpSaveChoiceNumber)){
            return lineFunctionDecide(tmpSaveChoiceNumber);
        }
        return lineFunctionInput();
    }
}

package subway;

import subway.domain.LineRepository;
import subway.view.OutputMessage;

import java.util.Arrays;
import java.util.function.Consumer;
import subway.domain.Line;

public enum LineFunctionChoice {
    ADD_LINE("1", (choiceKey)->LineRepository.addLine(new Line(OutputMessage.registerLineName())));
   // DELETE_LINE("2",),
   // LOOK_LINE("3",),
   // BACK("B",);
    private String choiceKey;
    private Consumer<String> handlerFunction;
    LineFunctionChoice(String choiceKey,Consumer<String> handlerFunction){
        this.choiceKey=choiceKey;
        this.handlerFunction=handlerFunction;
    }
    public void doingFunction(String name){
        handlerFunction.accept(name);
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

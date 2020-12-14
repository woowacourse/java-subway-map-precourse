package subway;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.OutputMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.logging.Handler;

public enum MainFunctionChoice {
    MANAGE_STATION("1",(choiceNumber)->StationCompute.manageStation()),
    MANAGE_LINE("2",(choiceNumber)->LineCompute.manageLine()),
    MANAGE_SECTION("3",(choiceNumber)->SectionCompute.manageSection()),
    LINE_LOOK("4",(choiceNumber)-> LineRepository.printAllLineInStation());
    private String choiceNumber;
    private Consumer<String> handleFunction;
    MainFunctionChoice(String choiceNumber,Consumer<String> handleFunction){
        this.choiceNumber=choiceNumber;
        this.handleFunction=handleFunction;
    }
    public void doingFunction(String name){
        handleFunction.accept(name);
    }
    public String getChoiceNumber(){
        return choiceNumber;
    }
    public static MainFunctionChoice choiceSubwayFunction(String choiceNumber){
       return Arrays.stream(values()).filter(value->value.choiceNumber.equals(choiceNumber)).findAny().get();
    }
    public static boolean checkInput(String choiceNumber){
        return Arrays.stream(values()).anyMatch(value->value.choiceNumber.equals(choiceNumber));
    }
    public static MainFunctionChoice mainFunctionInput(){
        String tmpSaveChoiceNumber=OutputMessage.choiceOutputMessage();
        if(checkInput(tmpSaveChoiceNumber)){
            return choiceSubwayFunction(tmpSaveChoiceNumber);
        }
        return mainFunctionInput();
    }
}

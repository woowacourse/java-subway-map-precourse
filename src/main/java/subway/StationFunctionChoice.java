package subway;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.OutputMessage;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

public enum StationFunctionChoice {

    ADD_STATION("1", ()->ControlStation.addStation()),
    DELETE_STATION("2",()-> ControlStation.deleteStationNotLine()),
    LOOK_STATION("3",()->ControlStation.lookStationNotLine()),
    BACK("B",()->ControlStation.stationBack());
    private String choiceKey;
    private Supplier<Boolean> handlerFunction;
    StationFunctionChoice(String choiceKey,Supplier<Boolean> handlerFunction){
        this.choiceKey=choiceKey;
        this.handlerFunction=handlerFunction;
    }
    public boolean doingFunction(){
        return handlerFunction.get();
    }
    public String getChoiceKey(){
        return choiceKey;
    }
    public static StationFunctionChoice stationFunctionDecide(String choiceKey){
       return Arrays.stream(values()).filter(value -> value.choiceKey.equals(choiceKey)).findFirst().get();

    }
    public static boolean checkInput(String choiceKey){
        return Arrays.stream(values()).anyMatch(value->value.choiceKey.equals(choiceKey));
    }
    public static StationFunctionChoice stationFunctionInput(String tmpSaveChoiceNumber){

        return stationFunctionDecide(tmpSaveChoiceNumber);


    }

}

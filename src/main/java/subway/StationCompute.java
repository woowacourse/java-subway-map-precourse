package subway;


import subway.domain.Station;
import subway.view.OutputMessage;

public class StationCompute {

    public static void manageStation(){
        OutputMessage.choiceStationOutputMessage();
        StationFunctionChoice choice = StationFunctionChoice.stationFunctionDecide(OutputMessage.choiceOutputMessage());
        if(choice.doingFunction()){
            manageStation();
        }
        System.out.println();
    }

}

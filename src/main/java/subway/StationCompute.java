package subway;


import subway.domain.Station;
import subway.view.OutputMessage;

public class StationCompute {

    public static void manageStation(){

        OutputMessage.choiceStationOutputMessage();

        StationFunctionChoice choice = StationFunctionChoice.stationFunctionDecide(OutputMessage.choiceOutputMessage());
        choice.doingFunction(choice.getChoiceKey());
        System.out.println("역 관리 끝");
    }
}

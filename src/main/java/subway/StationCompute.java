package subway;


import subway.domain.Station;
import subway.view.OutputMessage;

public class StationCompute {
    static String tmpSaveFunctionNumber;
    public static void manageStation(){
        OutputMessage.choiceStationOutputMessage();

        tmpSaveFunctionNumber=OutputMessage.choiceOutputMessage();
        if(!StationFunctionChoice.checkInput(tmpSaveFunctionNumber)){
            OutputMessage.setErrorMessageFunctionChoice();
            System.out.println();
            manageStation();
        }

        StationFunctionChoice choice = StationFunctionChoice.stationFunctionDecide(tmpSaveFunctionNumber);
        if(choice.doingFunction()){
            manageStation();
        }
        System.out.println();
    }

}

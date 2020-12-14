package subway;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.OutputMessage;
import java.util.Scanner;

public class SubwayMapMain {
    OutputMessage outputMessage=new OutputMessage();
    public SubwayMapMain(Scanner scanner){
        System.out.println("Ds");
        startSubwayMap();
    }
    public void startSubwayMap(){
        {
            while(true) {
                outputMessage.mainOutputMessage();
                MainFunctionChoice choice = MainFunctionChoice.mainFunctionInput();
                choice.doingFunction(choice.getChoiceNumber());
            }
        }
    }






}

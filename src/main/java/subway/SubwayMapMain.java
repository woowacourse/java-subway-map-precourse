package subway;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;

public class SubwayMapMain {
    OutputMessage outputMessage=new OutputMessage();
    StationRepository stationRepository= new StationRepository();
    private int choiceNumber=0;
    public SubwayMapMain(Scanner scanner){
        outputMessage.mainOutputMessage();
        this.choiceNumber=outputMessage.choiceOutputMessage(scanner);
        choiceFunction(choiceNumber,scanner);
    }

    public void choiceFunction(int choiceNumber,Scanner scanner){
        if(choiceNumber==1){
            outputMessage.choiceStationOutputMessage();
            int choiceNumberStationFunction=outputMessage.choiceOutputMessage(scanner);
            if(choiceNumberStationFunction==1){
                scanner.nextLine();
                String tmpSaveStation=scanner.nextLine();
                stationRepository.addStation(new Station(tmpSaveStation));
                stationRepository.print();
            }

        }
    }






}

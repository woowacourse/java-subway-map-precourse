package subway;

import subway.domain.StationRepository;
import subway.view.OutputMessage;
import subway.domain.Station;

public class ControlStation {

    public static void addStation(){

        StationRepository.addStation(new Station(OutputMessage.registerStationName()));
        System.out.println();
        System.out.println("등록끝");
    }
    public static void deleteStationNotLine(){
        StationRepository.deleteStation(OutputMessage.choiceOutputMessage());
    }
    public static void lookStation(){
        StationRepository.print();
    }
    public static void back(){
    }
}

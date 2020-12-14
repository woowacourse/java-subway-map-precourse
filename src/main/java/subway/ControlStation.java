package subway;


import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.OutputMessage;
import subway.domain.Station;

public class ControlStation {
    public static boolean addStation(){
        Boolean checkingInput=true;
        String tmpSaveStationName=OutputMessage.registerStationName();
        if(!StationRepository.lengthStationName(tmpSaveStationName)||!StationRepository.duplicateStationName(tmpSaveStationName)){
            OutputMessage.setErrorMessageAddStation();
            System.out.println();
            return true;
        }
        StationRepository.addStation(new Station(tmpSaveStationName));
        System.out.println();
        return false;
    }
    public static boolean deleteStationNotLine(){
        String tmpSaveStationName=OutputMessage.registerDeleteStation();
        if(LineRepository.checkingAllLine(tmpSaveStationName)||!StationRepository.deleteStation(tmpSaveStationName)){
            OutputMessage.setErrorMessageDeleteStation();
            System.out.println();
            return true;
        }
        return false;
    }
    public static boolean lookStationNotLine(){
        StationRepository.print();
        return false;
    }
    public static boolean back(){
        return false;
    }
}

package subway;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.OutputMessage;
import subway.domain.Line;
public class ControlLine {
    public static boolean addLine(){
        String tmpSaveLineName=OutputMessage.registerLineName();
        if(!lineRightChecking(tmpSaveLineName)){
            return false;
        }
        String upStation=OutputMessage.registerLineUpStation();
        if(!stationNameRightChecking(upStation)){
            return false;
        }
        String downStation=OutputMessage.registerLineDownStation();
        if(!stationNameRightChecking(downStation)){
            return false;
        }
        LineRepository.addLine(new Line(tmpSaveLineName,upStation,downStation));
        return true;
    }
    public static boolean deleteLine(){
        String tmpSaveLineName=OutputMessage.deleteLineName();
        if(!LineRepository.duplicateLineName(new Line(tmpSaveLineName))){
            OutputMessage.setErrorMessageDeleteLine();

            return false;
        }
        return true;
    }
    public static boolean lookLine(){
        LineRepository.printLine();
        return true;
    }
    public static boolean back(){
        return true;
    }
    public static boolean lineRightChecking(String tmpSaveLineName){
        if(LineRepository.lengthLineName(new Line(tmpSaveLineName))||LineRepository.duplicateLineName(new Line(tmpSaveLineName))){
            System.out.println();
            OutputMessage.setErrorMessageRegisterLine();
            return false;
        }
        return true;
    }
    public static boolean stationNameRightChecking(String tmpSaveStationName){
        if(!StationRepository.checkingStationName(tmpSaveStationName)){
            System.out.println();
            OutputMessage.setErrorMessageRegisterLine();
            return false;
        }
        return true;
    }
}

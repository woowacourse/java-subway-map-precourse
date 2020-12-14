package subway;

import subway.domain.LineRepository;
import subway.view.OutputMessage;
import subway.domain.Line;
public class ControlLine {
    public static boolean addLine(){
        String tmpSaveLineName=OutputMessage.registerLineName();
        if(LineRepository.lengthLineName(new Line(tmpSaveLineName))||LineRepository.duplicateLineName(new Line(tmpSaveLineName))){
            OutputMessage.setErrorMessageRegisterLine();
            return false;
        }
        LineRepository.addLine(new Line(tmpSaveLineName,OutputMessage.registerLineUpStation()));
        return true;
    }
    public static boolean deleteLine(){
        return true;
    }
    public static boolean lookLine(){
        return true;
    }
    public static boolean back(){
        return true;
    }
}

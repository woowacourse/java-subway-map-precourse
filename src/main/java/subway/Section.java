package subway;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.OutputMessage;

public class Section {
    public static boolean registerSection(){
        String tmpSaveSectionLineName=OutputMessage.sectionInputLine();
        if(!LineRepository.checkingAllLine(tmpSaveSectionLineName)){
            OutputMessage.setErrorMessageSectionAddLine();
            return false;
        }
        Line sectionLine= LineRepository.getLine(tmpSaveSectionLineName);
        String tmpSaveSectionStationName=OutputMessage.sectionInputStation();
        if(!StationRepository.checkingStationName(tmpSaveSectionStationName)||sectionLine.checkingAStationInLine(tmpSaveSectionStationName)){
            OutputMessage.setErrorMessageSectionAddLine();
            return false;
        }
        String tmpSaveSectionIndex=OutputMessage.sectionInputOrder();
        if(getRightIndex(tmpSaveSectionIndex,sectionLine)){
            OutputMessage.setErrorMessageSectionAddLine();
            return false;
        }
        sectionLine.addSectionLine(tmpSaveSectionStationName,Integer.parseInt(tmpSaveSectionIndex));
        return true;
    }
    public static boolean deleteSection(){
        Line sectionLine=LineRepository.getLine(OutputMessage.deleteLineName());
        sectionLine.deleteSectionLine(OutputMessage.deleteSectionStationName());
        return true;
    }
    public static boolean getRightIndex(String tmpSaveSectionIndex,Line tmpSectionLine){
        try{
            int saveSectionIndexInt=Integer.parseInt(tmpSaveSectionIndex);
            if(0<saveSectionIndexInt && tmpSectionLine.getLineInStationNumber()-1<saveSectionIndexInt){
                return true;
            }
        }catch (NumberFormatException e){
            return true;
        }
        return false;
    }
}

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
        String tmpSaveSectionLineName=OutputMessage.sectionInputLine();
        if(!LineRepository.checkingAllLine(tmpSaveSectionLineName)){
            System.out.println();
            OutputMessage.setErrorMessageSectionDeleteLine();
            return false;
        }
        Line sectionLine=LineRepository.getLine(tmpSaveSectionLineName);
        String tmpSaveSectionStationName=OutputMessage.deleteSectionStationName();
        if(!StationRepository.checkingStationName(tmpSaveSectionStationName)||sectionLine.getLineInStationNumber()<3){
            System.out.println();
            OutputMessage.setErrorMessageSectionDeleteLine();
            return false;
        }
        sectionLine.deleteSectionLine(tmpSaveSectionStationName);
        return true;
    }
    public static boolean back(){
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

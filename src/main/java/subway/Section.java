package subway;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.OutputMessage;

public class Section {
    private static final int NUMBER_ZERO=0;
    public static boolean registerSection(){
        String tmpSaveSectionLineName=OutputMessage.sectionInputLine();
        if(!lineNameChecking(tmpSaveSectionLineName)){
            return false;
        }
        Line sectionLine= LineRepository.getLine(tmpSaveSectionLineName);
        String tmpSaveSectionStationName=OutputMessage.sectionInputStation();
        if(!stationNameCheckingAndDuplicateChecking(sectionLine,tmpSaveSectionStationName)){
            return false;
        }
        String tmpSaveSectionIndex=OutputMessage.sectionInputOrder();
        if(!orderChecking(tmpSaveSectionIndex,sectionLine)){
            return false;
        }
        sectionLine.addSectionLine(tmpSaveSectionStationName,Integer.parseInt(tmpSaveSectionIndex));
        return true;
    }

    public static boolean deleteSection(){
        String tmpSaveSectionLineName=OutputMessage.sectionInputLine();
        if(!lineCheckingInRepository(tmpSaveSectionLineName)){
            return false;
        }
        Line sectionLine=LineRepository.getLine(tmpSaveSectionLineName);
        String tmpSaveSectionStationName=OutputMessage.deleteSectionStationName();
        if(!stationCheckingInLineAndCheckingLength(sectionLine,tmpSaveSectionStationName)){
            return false;
        }
        sectionLine.deleteSectionLine(tmpSaveSectionStationName);
        return true;
    }
    public static boolean stationCheckingInLineAndCheckingLength(Line sectionLine,String tmpSaveSectionStationName){
        if(!StationRepository.checkingStationName(tmpSaveSectionStationName)||sectionLine.getLineInStationNumber()<3){
            System.out.println();
            OutputMessage.setErrorMessageSectionDeleteLine();
            return false;
        }
        return true;
    }
    public static boolean lineCheckingInRepository(String tmpSaveSectionLineName){
        if(!LineRepository.checkingAllLine(tmpSaveSectionLineName)){
            System.out.println();
            OutputMessage.setErrorMessageSectionDeleteLine();
            return false;
        }
        return true;
    }
    public static boolean sectionBack(){
        return true;
    }
    public static boolean getRightIndex(String tmpSaveSectionIndex,Line tmpSectionLine){
        int maxInsertLineStationNumber=tmpSectionLine.getLineInStationNumber()-1;
        try{
            int saveSectionIndexInt=Integer.parseInt(tmpSaveSectionIndex);
            if(NUMBER_ZERO<saveSectionIndexInt && maxInsertLineStationNumber<saveSectionIndexInt){
                return true;
            }
        }catch (NumberFormatException e){
            return true;
        }
        return false;
    }
    public static boolean orderChecking(String tmpSaveSectionIndex,Line sectionLine){
        if(getRightIndex(tmpSaveSectionIndex,sectionLine)){
            OutputMessage.setErrorMessageSectionAddLine();
            return false;
        }
        return true;
    }
    public static boolean stationNameCheckingAndDuplicateChecking(Line sectionLine,String tmpSaveSectionStationName){
        if(!StationRepository.checkingStationName(tmpSaveSectionStationName)||sectionLine.checkingAStationInLine(tmpSaveSectionStationName)){
            OutputMessage.setErrorMessageSectionAddLine();
            return false;
        }
        return true;
    }
    public static boolean lineNameChecking(String tmpSaveSectionLineName){
        if(!LineRepository.checkingAllLine(tmpSaveSectionLineName)){
            OutputMessage.setErrorMessageSectionAddLine();
            return false;
        }
        return true;
    }
}

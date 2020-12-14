package subway;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.OutputMessage;

public class Section {
    public static void registerSection(){
        Line sectionLine= LineRepository.getLine(OutputMessage.sectionInputLine());
        sectionLine.addSectionLine(OutputMessage.sectionInputStation(),OutputMessage.sectionInputOrder());
    }
    public static void deleteSection(){
        Line sectionLine=LineRepository.getLine(OutputMessage.deleteLineName());
        sectionLine.deleteSectionLine(OutputMessage.deleteSectionStationName());

    }
}

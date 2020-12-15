package subway.domain.selector.sectionitem;

import java.util.List;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;
import subway.domain.selector.lineitem.LineValidator;
import subway.domain.selector.stationitem.StationValidator;

public class RemoveSectionItem extends Selector implements Manipulable {

    SectionValidator sectionValidator = new SectionValidator();
    LineValidator lineValidator = new LineValidator();
    StationValidator stationValidator = new StationValidator();

    public RemoveSectionItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute() {
        messageView.printSectionRemoveLineInputMessage();

        String lineName = inputView.getName();
        Line line = LineRepository.getLineByName(lineName);
        lineValidator.validateContainsLines(lineName);

        messageView.printSectionRemoveStationInputMessage();
        String stationName = inputView.getName();
        stationValidator.validateContainsStations(stationName);
        sectionValidator.validateStationCount(line);
        line.deleteStationByName(stationName);

        messageView.printSectionRemoveSuccessMessage();
    }

}

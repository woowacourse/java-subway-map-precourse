package subway.domain.selector.sectionitem;

import java.util.List;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;
import subway.domain.selector.lineitem.LineValidator;
import subway.domain.selector.stationitem.StationValidator;
import subway.domain.station.Station;

public class AddSectionItem extends Selector implements Manipulable {

    LineValidator lineValidator = new LineValidator();
    StationValidator stationValidator = new StationValidator();
    SectionValidator sectionValidator = new SectionValidator();

    public AddSectionItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute() {
        messageView.printSectionLineInputMessage();
        String lineName = inputView.getName();
        lineValidator.validateContainsLines(lineName);

        messageView.printSectionStationNameInputMessage();
        String stationName = inputView.getName();
        stationValidator.validateContainsStations(stationName);

        messageView.printSectionOrderInputMessage();
        int order = inputView.getNumber();
        addStation(lineName, stationName, order);

        messageView.printSectionRegisterSuccessMessage();
    }

    private void addStation(String lineName, String stationName, int order) {
        Line line = LineRepository.getLineByName(lineName);
        List<Station> stations = line.stations();
        sectionValidator.validateSectionOrder(order, stations.size());
        Station station = new Station(stationName);
        sectionValidator.validateStationsDuplication(line, station);
        line.addStationByIndex(station, order - 1);
    }

}



package subway.domain.selector.lineitem;

import java.util.LinkedList;
import java.util.List;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;
import subway.domain.selector.stationitem.StationValidator;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class AddLineItem extends Selector implements Manipulable {

    LineValidator lineValidator = new LineValidator();
    StationValidator stationValidator = new StationValidator();

    public AddLineItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Station> makeStations() {
        messageView.printUpwardTerminalStationInputMessage();
        String UpwardTerminalStationName = inputView.getName();
        messageView.printDownTerminalStationInputMessage();
        String DownTerminalStationName = inputView.getName();

        stationValidator.validateContainsStations(UpwardTerminalStationName);
        stationValidator.validateContainsStations(DownTerminalStationName);

        List<Station> stations = new LinkedList<>();
        stations.add(new Station(UpwardTerminalStationName));
        stations.add(new Station(DownTerminalStationName));
        return stations;
    }

    @Override
    public void execute() {
        messageView.printAddLineMessage();

        String lineName = inputView.getName();
        lineValidator.validateAddLine(lineName);

        Line line = new Line(lineName);
        line.addAllStation(makeStations());
        LineRepository.addLine(line);

        messageView.printAddLineSuccessMessage();
    }

}

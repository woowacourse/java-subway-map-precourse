package subway.domain.selector.stationitem;

import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;
import subway.domain.station.StationRepository;

public class StationGetter extends Selector implements Manipulable {

    public StationGetter(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute() {
        messageView.printGetStationsMessage();
        outputView.printStations(StationRepository.stations());
    }
}

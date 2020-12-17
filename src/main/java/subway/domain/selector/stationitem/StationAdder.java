package subway.domain.selector.stationitem;

import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class StationAdder extends Selector implements Manipulable {

    StationValidator stationValidator = new StationValidator();

    public StationAdder(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute() {
        messageView.printAddStationMessage();

        String stationName = inputView.getName();
        stationValidator.validateAddStation(stationName);
        StationRepository.addStation(new Station(stationName));

        messageView.printAddStationSuccessMessage();
    }

}

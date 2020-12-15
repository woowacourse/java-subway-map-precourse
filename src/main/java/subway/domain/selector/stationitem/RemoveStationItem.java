package subway.domain.selector.stationitem;

import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;
import subway.domain.station.StationRepository;

public class RemoveStationItem extends Selector implements Manipulable {

    StationValidator stationValidator = new StationValidator();

    public RemoveStationItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute() {
        messageView.printRemoveStationMessage();

        String stationName = inputView.getName();
        stationValidator.validateRemoveStation(stationName);
        StationRepository.deleteStationByName(stationName);

        messageView.printRemoveStationSuccessMessage();
    }

}

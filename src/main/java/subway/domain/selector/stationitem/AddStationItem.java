package subway.domain.selector.stationitem;

import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;

public class AddStationItem extends Selector implements Manipulable {

    public AddStationItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute() {

    }

}

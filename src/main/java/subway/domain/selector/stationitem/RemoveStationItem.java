package subway.domain.selector.stationitem;

import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;

public class RemoveStationItem extends Selector implements Manipulable {

    public RemoveStationItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute() {

    }

}

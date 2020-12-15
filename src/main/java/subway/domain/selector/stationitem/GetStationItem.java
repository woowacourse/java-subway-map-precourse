package subway.domain.selector.stationitem;

import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;

public class GetStationItem extends Selector implements Manipulable {

    public GetStationItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute() {

    }

}

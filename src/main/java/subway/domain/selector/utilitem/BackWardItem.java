package subway.domain.selector.utilitem;

import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;

public class BackWardItem extends Selector implements Manipulable {

    public BackWardItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

}

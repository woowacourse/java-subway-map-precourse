package subway.domain.selector.utilitem;

import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;

public class ExitItem extends Selector implements Manipulable {

    public ExitItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

}

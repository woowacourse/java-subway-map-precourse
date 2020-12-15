package subway.domain.selector.sectionitem;

import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;

public class RemoveSectionItem extends Selector implements Manipulable {

    public RemoveSectionItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute() {

    }

}

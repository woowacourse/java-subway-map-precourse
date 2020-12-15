package subway.domain.selector.sectionitem;

import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;

public class AddSectionItem extends Selector implements Manipulable {

    public AddSectionItem(String id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute() {

    }

}

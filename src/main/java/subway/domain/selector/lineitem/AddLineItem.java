package subway.domain.selector.lineitem;

import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;

public class AddLineItem extends Selector implements Manipulable {

    public AddLineItem(String id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute() {

    }

}

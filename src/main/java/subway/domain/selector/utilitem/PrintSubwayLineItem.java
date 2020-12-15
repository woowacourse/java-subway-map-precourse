package subway.domain.selector.utilitem;

import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;

public class PrintSubwayLineItem extends Selector implements Manipulable {

    public PrintSubwayLineItem(String id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute() {

    }

}

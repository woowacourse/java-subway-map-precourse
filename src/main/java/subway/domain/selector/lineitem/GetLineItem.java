package subway.domain.selector.lineitem;

import subway.domain.line.LineRepository;
import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;

public class GetLineItem extends Selector implements Manipulable {

    public GetLineItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute() {
        messageView.printGetLinesMessage();
        outputView.printLines(LineRepository.lines());
    }
}

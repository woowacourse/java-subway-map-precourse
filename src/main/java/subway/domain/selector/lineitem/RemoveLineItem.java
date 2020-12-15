package subway.domain.selector.lineitem;

import subway.domain.line.LineRepository;
import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;

public class RemoveLineItem extends Selector implements Manipulable {

    LineValidator lineValidator = new LineValidator();

    public RemoveLineItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute() {
        messageView.printRemoveLineInputMessage();

        String lineName = inputView.getName();
        lineValidator.validateContainsLines(lineName);
        LineRepository.deleteLineByName(lineName);

        messageView.printRemoveLineSuccessMessage();
    }
}

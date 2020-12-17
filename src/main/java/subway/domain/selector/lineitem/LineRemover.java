package subway.domain.selector.lineitem;

import subway.domain.line.LineRepository;
import subway.domain.selector.Manipulable;
import subway.domain.selector.Selector;

public class LineRemover extends Selector implements Manipulable {

    LineValidator lineValidator = new LineValidator();

    public LineRemover(String id, String name) {
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

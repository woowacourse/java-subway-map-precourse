package subway.domain.selector;

import subway.view.InputView;
import subway.view.MessageView;
import subway.view.OutputView;

public abstract class Selector {

    protected String id;
    protected String name;
    protected InputView inputView = new InputView();
    protected OutputView outputView = new OutputView();
    protected MessageView messageView = new MessageView();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}

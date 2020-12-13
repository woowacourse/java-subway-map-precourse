package subway.view;

import subway.service.output.OutputService;

public abstract class Screen {
    protected final OutputService outputService;

    public Screen(OutputService outputService) {
        this.outputService = outputService;
    }

    public abstract void showOptions();

    public abstract void showAdd();

    public abstract void showDelete();

    public abstract void showAfterAdd();

    public abstract void showAfterDelete();
}

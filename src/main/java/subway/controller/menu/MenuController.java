package subway.controller.menu;

import java.util.ArrayList;
import java.util.List;
import subway.controller.Controller;
import subway.view.InputView;

public abstract class MenuController implements Controller {

    protected final InputView inputView;
    protected final List<Controller> childControllers = new ArrayList<>();

    public MenuController(InputView inputView) {
        this.inputView = inputView;
    }

    public abstract void run();

    protected abstract void runChildController(String input);
}

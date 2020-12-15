package subway.controller.menu;

import subway.controller.line.LineAddController;
import subway.controller.line.LineDeleteController;
import subway.controller.line.LineViewController;
import subway.view.InputView;
import subway.view.OutputView;

public class LineMenuController extends MenuController {

    public LineMenuController(InputView inputView) {
        super(inputView);
        childControllers.add(new LineAddController(inputView));
        childControllers.add(new LineDeleteController(inputView));
        childControllers.add(new LineViewController());
    }

    @Override
    protected void printMenu() {
        OutputView.printLineMenu();
    }
}

package subway.controller.menu;

import subway.controller.section.SectionAddController;
import subway.controller.section.SectionDeleteController;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionMenuController extends MenuController {

    public SectionMenuController(InputView inputView) {
        super(inputView);
        childControllers.add(new SectionAddController(inputView));
        childControllers.add(new SectionDeleteController(inputView));
    }

    @Override
    protected void printMenu() {
        OutputView.printSectionMenu();
    }
}

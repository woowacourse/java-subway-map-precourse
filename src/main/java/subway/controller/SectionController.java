package subway.controller;

import static subway.service.menu.SectionMenu.callSectionFunction;

import subway.service.menu.SectionMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController implements Controller {

    private final String BACK = "B";

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    @Override
    public void runMenu() {
        while (true) {
            outputView.printMenu(SectionMenu.getMenu());
            String input = inputView.getInput(SELECT_FUNCTION);
            if (isEnd(input)) {
                break;
            }
            try {
                callSectionFunction(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    @Override
    public boolean isEnd(String input) {
        return input.equals(BACK);
    }


}

package subway.controller;

import static subway.service.menu.LineMenu.callLineFunction;

import subway.service.menu.LineMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController implements Controller {

    private final String BACK = "B";

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    @Override
    public void runMenu() {
        while (true) {
            outputView.printMenu(LineMenu.getMenu());
            String input = inputView.getInput(SELECT_FUNCTION);
            if (isEnd(input)) {
                break;
            }
            try {
                callLineFunction(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    @Override
    public boolean isEnd (String input){
        return input.equals(BACK);
    }
}

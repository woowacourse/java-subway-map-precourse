package subway.controller;

import static subway.service.menu.StationMenu.callFunction;

import subway.service.menu.StationMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController implements Controller {

    private final String BACK ="B";

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    @Override
    public void runMenu() {
        while (true) {
            outputView.printMenu(StationMenu.getMenu());
            String input = inputView.getInput(SELECT_FUNCTION);
            if (isEnd(input)) {
                break;
            }
            try {
                callFunction(input);
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


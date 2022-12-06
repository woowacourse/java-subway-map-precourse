package subway.controller;

import static subway.service.menu.MainMenu.callMainFunction;

import subway.service.menu.MainMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController implements Controller {

    private final String QUIT = "Q";

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    @Override
    public void runMenu() {
        while (true) {
            outputView.printMenu(MainMenu.getMenu());
            String input = inputView.getInput(SELECT_FUNCTION);
            if (isEnd(input)) {
                break;
            }
            try {
                callMainFunction(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
                runMenu();
            }
        }
    }

    @Override
    public boolean isEnd(String input) {
        return input.equals(QUIT);
    }
}

package subway;

import subway.exception.MenuNotFountException;
import subway.menu.MainMenu;
import subway.menu.Menu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayMap {

    private static Menu state = MainMenu.QUIT;
    private InputView inputView;

    public SubwayMap(Scanner scanner) {
        InputView.initScanner(scanner);
        this.inputView = InputView.getInstance();
    }

    public void run() {

        while (checkState()) {

            printMenu();

            selectMenu();

            menuRen();
        }
    }


    private boolean checkState() {
        return state != null;
    }

    private void selectMenu() {

        String input = inputView.selectMenu();

        try {
            this.state = state.change(input);
        } catch (MenuNotFountException e) {
            OutputView.printErrorMessage(e);
        }
    }

    private void menuRen() {
        this.state = state.run();
    }

    private void printMenu() {
        OutputView.printMenu(state);
    }

}

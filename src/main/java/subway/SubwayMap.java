package subway;

import subway.exception.MenuNotFountException;
import subway.menu.MainMenu;
import subway.menu.Menu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
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

        }
    }


    private boolean checkState() {
        return state != null;
    }

    private void selectMenu() {

        String input = inputView.selectMenu();

        try {
            this.state = change(input);
            menuRen();
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
        }


    }

    private void menuRen() {
        this.state = state.run();
    }

    private Menu change(String input) {
        return searchMenuList(input);
    }

    private Menu searchMenuList(String input) {
        return Arrays.stream(state.getValues())
                .filter(menu -> menu.getOrder().equals(input))
                .findFirst().orElseThrow(() ->
                        new MenuNotFountException(input)
                );
    }

    private void printMenu() {
        OutputView.printMenu(state);
    }

}

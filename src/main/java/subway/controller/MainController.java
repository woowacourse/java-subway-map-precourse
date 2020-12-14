package subway.controller;

import subway.domain.menu.MainMenu;
import subway.domain.menu.NoSuchMenuException;
import subway.view.InputView;
import subway.view.outputview.MainOutputView;

import java.util.Objects;

public class MainController implements Controller {
    Controller controller;

    @Override
    public void start() {
        MainOutputView.printAll(LineController.informAllLines());
    }

    public void run() {
        MainMenu menu;
        do {
            MainOutputView.showMenu();
            String inputMenu = InputView.inputMainMenu();
            menu = selectMenu(inputMenu);
        } while (isRunning(menu));
    }

    private MainMenu selectMenu(String inputMenu) {
        try {
            MainMenu menu = MainMenu.findMenu(inputMenu);
            execute(menu);
            return menu;
        } catch (NoSuchMenuException e) {
            return null;
        }
    }

    private void execute(MainMenu menu) {
        if (!isRunning(menu)) {
            return;
        }
        menu.getController().start();
    }


    private boolean isRunning(MainMenu menu) {
        return !Objects.equals(menu, MainMenu.EXIT);
    }
}

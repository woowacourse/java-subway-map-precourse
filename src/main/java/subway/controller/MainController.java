package subway.controller;

import subway.controller.line.LineController;
import subway.domain.menu.MainMenu;
import subway.domain.exception.NoSuchMenuException;
import subway.view.InputView;
import subway.view.outputview.MainOutputView;

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
            String inputMenu = InputView.input();
            menu = selectMenu(inputMenu);
        } while (MainMenu.isRunning(menu));
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
        if (MainMenu.isRunning(menu)) {
            menu.getController().start();
        }
    }
}

package subway;

import static subway.initialization.InitSubway.initSubway;

import subway.controller.MainController;

public class Application {

    public static void main(String[] args) {
        initSubway();
        MainController mainController = new MainController();
        mainController.runMenu();
    }
}

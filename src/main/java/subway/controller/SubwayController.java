package subway.controller;

import subway.exception.SubwayException;
import subway.repository.InitialRepository;
import subway.view.OutputView;
import subway.view.main.MainMenu;
import subway.view.main.MainScreen;

public class SubwayController {
    private final InitialRepository initialRepository;

    public SubwayController() {
        initialRepository = new InitialRepository();
    }

    public void start() {
        initialRepository.initialize();
        while (true) {
            Menu();
        }
    }

    private void Menu() {
        try {
            MainMenu menu = MainScreen.selectMenu();
            menu.request(menu.getKey());
        } catch (SubwayException e) {
            OutputView.printErrorMessage(e);
        }
    }
}

package subway.controller.station;

import subway.controller.Controller;
import subway.domain.StationRepository;
import subway.domain.exception.NoSuchMenuException;
import subway.domain.menu.StationMenu;
import subway.view.InputView;
import subway.view.outputview.StationOutputView;

public class StationController implements Controller {
    private static StationRepository stationRepository = new StationRepository();

    @Override
    public void start() {
        StationMenu stationMenu;
        do {
            StationOutputView.showMenu();
            String inputMenu = InputView.input();
            stationMenu = selectMenu(inputMenu);
        } while (StationMenu.isRunning(stationMenu));
    }

    private StationMenu selectMenu(String inputMenu) {
        try {
            StationMenu stationMenu = StationMenu.findMenu(inputMenu);
            execute(stationMenu);
            return stationMenu;
        } catch (NoSuchMenuException e) {
            return null;
        }
    }

    private void execute(StationMenu stationMenu) {
        if (StationMenu.isRunning(stationMenu)) {
            stationMenu.runFunction(stationRepository);
        }
    }
}

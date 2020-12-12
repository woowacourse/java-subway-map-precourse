package subway.controller;

import subway.menu.*;

public class ControllerFactory {

    private static final SubwayController stationController = new StationController();
    private static final SubwayController lineController = new LineController();
    private static final SubwayController sectionController = new SectionController();
    private static final SubwayController mainController = new MainController();

    private ControllerFactory() {
    }

    public static SubwayController of(Menu menu) {

        if (menu instanceof StationMenu) {
            return stationController;
        }
        if (menu instanceof LineMenu) {
            return lineController;
        }
        if (menu instanceof SectionMenu) {
            return sectionController;
        }
        return mainController;
    }

}

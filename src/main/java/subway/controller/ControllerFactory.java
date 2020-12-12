package subway.controller;

import subway.menu.*;

public class ControllerFactory {

    private ControllerFactory() {
    }

    public static SubwayController of(Menu menu) {

        if (menu instanceof StationMenu) {
            return new StationController();
        }
        if (menu instanceof LineMenu) {
            return new LineController();
        }
        if (menu instanceof SectionMenu) {
            return new SectionController();
        }
        return null;
    }

}

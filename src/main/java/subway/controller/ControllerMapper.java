package subway.controller;

import subway.view.screen.Element;

public class ControllerMapper {

    public static final Controller mapping(String name) {
        if (Element.STATION.getElement().equals(name)) {
            return new StationController();
        }
        return new LineController(); //Station Or Line
    }
}

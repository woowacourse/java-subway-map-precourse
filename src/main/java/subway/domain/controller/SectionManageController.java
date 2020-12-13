package subway.domain.controller;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.input.SectionManageInput;

public class SectionManageController {

    static final int MIN_STATIONS = 2;

    SectionManageInput input = new SectionManageInput();

    public void processEnrollSection(Line line, Station station, int order) {
        line.addOrderedStation(station, order);
    }

    public void processDeleteSection(Line line, Station station) {
        if (line.getStation().size() > MIN_STATIONS) {
            line.removeOrderedStation(station);
            station.removeOrderedLine(line);
        }
    }

}

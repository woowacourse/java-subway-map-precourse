package subway.domain.controller;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.input.SectionManageInput;

public class SectionManageController {

    static final int MIN_STATIONS = 2;
    static final int ORDER_SUBTRACT_INDEX = 1;

    SectionManageInput input = new SectionManageInput();

    public void processEnrollSection(Line line, Station station, int order) throws IllegalArgumentException{
        if (order - ORDER_SUBTRACT_INDEX > line.getStation().size()) {
            //해당 번째로 구간 삽입 불가능 메시지
            throw new IllegalArgumentException();
        }
        line.addOrderedStation(station, order);
    }

    public void processDeleteSection(Line line, Station station) {
        if (line.getStation().size() > MIN_STATIONS) {
            line.removeOrderedStation(station);
            station.removeOrderedLine(line);
        }
    }

}

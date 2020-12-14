package subway.domain.controller;

import subway.domain.ErrorMessage;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class SectionManageController {

    static final int MIN_STATIONS = 2;
    static final int ORDER_SUBTRACT_INDEX = 1;

    public void checkStationInLine(Line line, Station station) throws IllegalArgumentException {
        if (line.getStation().contains(station)) {
            ErrorMessage.isAlreadyExistStationInLine();
            throw new IllegalArgumentException();
        }
    }

    public void processEnrollSection(Line line, Station station, int order) throws IllegalArgumentException {
        if (order - ORDER_SUBTRACT_INDEX > line.getStation().size()) {
            ErrorMessage.isNotAbleToInsert();
            throw new IllegalArgumentException();
        }
        line.addOrderedStation(station, order);
    }

    public void processDeleteSection(Line line, Station station) throws IllegalArgumentException {
        if (line.getStation().size() <= MIN_STATIONS) {
            ErrorMessage.isLessThanTwoStation();
            throw new IllegalArgumentException();
        }
        if (LineRepository.isFixedStationOnLine(station, line)) {
            ErrorMessage.isNotAbleToDeleteStation();
            throw new IllegalArgumentException();
        }
        line.removeOrderedStation(station);
        station.removeOrderedLine(line);
    }

}

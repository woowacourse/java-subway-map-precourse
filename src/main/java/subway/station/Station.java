package subway.station;

import subway.station.validation.CheckLastLetter;
import subway.station.validation.CheckNameDuplicate;
import subway.station.validation.CheckNameLength;

public class Station {
    private String name;

    public Station(String name) {
        validStationName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validStationName(String name) {
        CheckNameLength.validation(name);
        CheckNameDuplicate.validation(name);
        CheckLastLetter.validation(name);
    }
}

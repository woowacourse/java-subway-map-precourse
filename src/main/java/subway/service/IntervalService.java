package subway.service;

import subway.domain.Line;
import subway.domain.Station;

public class IntervalService {

    public void registerInterval(Line currLine, Station inputStation, int position) {
        currLine.addIntervals(inputStation, position);
        inputStation.addRegisteredLine(currLine);
    }
}

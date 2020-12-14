package subway.service;

import subway.domain.Line;
import subway.domain.Station;

public class IntervalService {
    private static final int MIN_LINE_SIZE = 2;
    private static final String LINE_UNDER_TWO = "\n[ERROR] 노선에 등록된 역이 2개 이하 입니다.";

    public void registerInterval(Line currLine, Station inputStation, int position) {
        currLine.addIntervals(inputStation, position);
        inputStation.addRegisteredLine(currLine);
    }

    public void deleteInterval(Line currLine, Station deleteStation) throws
            IllegalArgumentException {
        validateLineSize(currLine);
        currLine.deleteIntervals(deleteStation);
    }

    private void validateLineSize(Line currLine) throws IllegalArgumentException {
        if (currLine.intervals().size() < MIN_LINE_SIZE) {
            throw new IllegalArgumentException(LINE_UNDER_TWO);
        }
    }
}

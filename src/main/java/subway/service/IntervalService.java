package subway.service;

import subway.domain.Line;
import subway.domain.Station;

public class IntervalService {
    private static final int MIN_LINE_SIZE = 2;
    private static final String LINE_UNDER_TWO = "\n[ERROR] 노선에 등록된 역이 2개 이하 입니다.";
    private static final String DUPLICATED_INTERVAL = "\n[ERROR] 이미 등록되어 있는 구간 입니다.";

    public void registerInterval(Line currLine, Station inputStation, int position) throws
            IllegalArgumentException {
        validateDuplicatedStationInterval(currLine, inputStation);
        currLine.addIntervals(inputStation, position);
        inputStation.addRegisteredLine(currLine);
    }

    private void validateDuplicatedStationInterval(
            Line currLine, Station inputStation) throws IllegalArgumentException {
        if (currLine.intervals().contains(inputStation)) {
            throw new IllegalArgumentException(DUPLICATED_INTERVAL);
        }
    }

    public void deleteInterval(Line currLine, Station deleteStation) throws
            IllegalArgumentException {
        validateLineSize(currLine);
        currLine.deleteIntervals(deleteStation);
        deleteStation.deleteRegisteredLine(currLine);
    }

    private void validateLineSize(Line currLine) throws IllegalArgumentException {
        if (currLine.intervals().size() <= MIN_LINE_SIZE) {
            throw new IllegalArgumentException(LINE_UNDER_TWO);
        }
    }
}

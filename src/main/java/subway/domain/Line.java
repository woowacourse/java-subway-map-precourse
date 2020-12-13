package subway.domain;


import static subway.resource.Config.MIN_LINE_NAME_LENGTH;
import static subway.resource.TextResource.ERROR_LINE_NAME_LENGTH;
import static subway.resource.TextResource.ERROR_NOT_EXISTENCE_STATION;
import static subway.resource.TextResource.ERROR_START_END_STATION_DUPLICATED;

public class Line {

    private String name;

    public Line(String name, String start, String end) {
        this.name = name;

        if (name.length() < MIN_LINE_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_LINE_NAME_LENGTH);
        }

        if (!StationRepository.hasStation(start) || !StationRepository.hasStation(end)) {
            throw new IllegalArgumentException(ERROR_NOT_EXISTENCE_STATION);
        }

        if (start.equals(end)) {
            throw new IllegalArgumentException(ERROR_START_END_STATION_DUPLICATED);
        }
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

}

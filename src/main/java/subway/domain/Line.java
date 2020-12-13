package subway.domain;


import static subway.resource.TextResource.ERROR_LINE_NAME_LENGTH;
import static subway.resource.TextResource.ERROR_NOT_EXISTENCE_STATION;
import static subway.resource.TextResource.ERROR_START_END_STATION_DUPLICATED;

import java.util.LinkedList;

public class Line {
    public static final int MIN_LINE_NAME_LENGTH = 2;
    private String name;
    private Sections sections;

    public Line(String name, String start, String end) {
        this.name = name;
        checkValidation(start, end);
        LinkedList<String> stations = new LinkedList();
        stations.addFirst(start);
        stations.addLast(end);
        this.sections = new Sections(stations);
    }

    private void checkValidation(String start, String end) {
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

    public Sections getSections() {
        return sections;
    }



}

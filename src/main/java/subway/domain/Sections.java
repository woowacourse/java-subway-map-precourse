package subway.domain;

import static subway.resource.TextResource.ERROR_NOT_EXISTENCE_STATION;
import static subway.resource.TextResource.ERROR_SECTIONS_POSITION_NOT_VALID;
import static subway.resource.TextResource.ERROR_STATION_DUPLICATED_IN_SECTION;

import java.util.LinkedList;

public class Sections {

    private LinkedList<String> sections;

    public Sections(LinkedList sections) {
        this.sections = sections;
    }

    public void addSection(String name, int position) {
        if (!StationRepository.hasStation(name)) {
            throw new IllegalArgumentException(ERROR_NOT_EXISTENCE_STATION);
        }

        if (hasStationInSection(name)) {
            throw new IllegalArgumentException(ERROR_STATION_DUPLICATED_IN_SECTION);
        }

        if (position < 0 || position > sections.size()) {
            throw new IllegalArgumentException(ERROR_SECTIONS_POSITION_NOT_VALID);
        }

        sections.add(position, name);
    }

    public boolean hasStationInSection(String name) {
        return sections.contains(name);
    }
}

package subway.domain;

import subway.exception.DuplicateStationException;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private List<Station> section;

    public Section() {
        this.section = new ArrayList<>();
    }

    public boolean contains(Station station) {
        if (getSection().contains(station)) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (getSection().isEmpty()) {
            return true;
        }
        return false;
    }

    public void removeSection(Station station) {
        this.getSection().remove(station);
    }

    public List<Station> getSection() {
        return section;
    }

    public void initiateSection(Station upstreamStation, Station downstreamStation) {
        validateIfDuplicate(upstreamStation, downstreamStation);
        this.getSection().add(upstreamStation);
        this.getSection().add(downstreamStation);
    }

    private void validateIfDuplicate(Station upstreamStation, Station downstreamStation) {
        if (upstreamStation.equals(downstreamStation)) {
            throw new DuplicateStationException();
        }
    }
}

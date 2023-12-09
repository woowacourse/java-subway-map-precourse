package subway.domain;

import java.util.Collections;
import java.util.List;

public class Section {
    private static final int OFFSET = 1;
    private final List<Station> sections;

    public Section(List<Station> sections) {
        this.sections = sections;
    }

    public int size() {
        return sections.size();
    }

    public void add(int index, Station station) {
        this.sections.add(index, station);
    }

    public void remove(Station station) {
        this.sections.remove(station);
    }

    public Station getAscendingStation() {
        return this.sections.get(0);
    }

    public Station getDescendingStation() {
        return this.sections.get(this.sections.size() - OFFSET);
    }

    public boolean contains(Station station) {
        return this.sections.contains(station);
    }

    public List<Station> getSection() {
        return Collections.unmodifiableList(this.sections);
    }

    public boolean isRemovable() {
        return this.sections.size() > 2;
    }
}

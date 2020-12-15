package subway.domain;

import subway.exception.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    private static final int MINIMUM_SECTION_LENGTH = 2;

    private final List<Station> section = new LinkedList<>();
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public List<Station> sections() {
        return Collections.unmodifiableList(section);
    }


    public boolean contains(String stationName) {
        Station find = StationRepository.findStationByName(stationName);
        if (find == null) {
            return false;
        }
        return section.contains(find);
    }

    public boolean contains(Station station) {
        return section.contains(station);
    }

    public boolean canRemove() {
        return section.size() > MINIMUM_SECTION_LENGTH;
    }

    public boolean isValidSection(int index) {
        return section.size() >= index && index >= 0;
    }

    public boolean addStation(int index, Station station) {
        try {
            if (!isValidSection(index)) {
                throw new SectionIndexOutOfBoundException();
            } else if(section.contains(station)) {
                throw new StationDuplicationException(station);
            }
            section.add(index, station);
        } catch (SubwayException e) {
            System.out.println(e.getMessage() + "\n");
            return false;
        }
        return true;
    }

    public void addStation(String name) {
        if (StationRepository.contains(name)) {
            section.add(StationRepository.findStationByName(name));
        }
    }

    public boolean removeStationByName(String name) {

        try {
            if (!canRemove()) {
                throw new MinimumSectionLengthException(MINIMUM_SECTION_LENGTH);
            }

            return section.removeIf(station -> Objects.equals(station.getName(), name));
        } catch (MinimumLengthException e) {
            System.out.println(e.getMessage() + "\n");
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Line) {
            Line compare = (Line) obj;
            return this.getName().equals(compare.getName());
        }

        return false;
    }
}

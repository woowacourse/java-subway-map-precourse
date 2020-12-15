package subway.domain;

import java.util.ArrayList;

import static subway.domain.StationRepository.searchStation;

public class Line {
    public static final int INDEX_START_STATION = 0;
    public static final int INDEX_END_STATION = 1;
    public static final String ERROR_MSG_INVALID_ORDER = "[ERROR] 잘못된 순서입니다.";
    public static final int INT_ZERO_SIZE = 0;
    public static final String ERROR_MSG_HAS_DUPLICATE_STATION_IN_SECTION = "[ERROR] 노선에 중복된 역이 존재합니다.";
    public static final String PREFIX_INFO = "[INFO] ";
    public static final String HORIZONTAL_LINE = "---";
    public static final String NEW_LINE = "\n";
    private String name;
    private ArrayList<Station> section;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void initializeSection(String start, String end) throws IllegalArgumentException {
        section = new ArrayList<>();
        addStationToSection(INDEX_START_STATION, start);
        addStationToSection(INDEX_END_STATION, end);
    }

    public void addStationToSection(int index, String name) throws IllegalArgumentException {
        validatePossibleIndex(index);
        validateNotDuplicate(name);
        section.add(index, searchStation(name));
    }

    private void validatePossibleIndex(int index) {
        if (index > section.size() || index < INT_ZERO_SIZE) {
            throw new IllegalArgumentException(ERROR_MSG_INVALID_ORDER);
        }
    }

    private void validateNotDuplicate(String name) {
        for (Station station : section) {
            if (station.getName().equals(name)) {
                throw new IllegalArgumentException(ERROR_MSG_HAS_DUPLICATE_STATION_IN_SECTION);
            }
        }
    }

    public boolean deleteStationFromSection(String name) {
        return section.removeIf(station -> station.getName().equals(name));
    }

    public boolean hasStation(String name) {
        for (Station station : section) {
            if (station.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Integer sectionLength() {
        return section.size();
    }

    @Override
    public String toString() {
        String topString = PREFIX_INFO + name + NEW_LINE;
        String horizontalLine = PREFIX_INFO + HORIZONTAL_LINE + NEW_LINE;
        StringBuilder sb = new StringBuilder();
        for (Station station : section) {
            sb.append(PREFIX_INFO);
            sb.append(station.getName());
            sb.append(NEW_LINE);
        }
        return topString + horizontalLine + sb;
    }
}

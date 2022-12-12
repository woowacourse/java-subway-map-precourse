package subway.domain;

import constants.ExceptionMessage;

import java.util.*;

public class SectionRepository {
    // TODO: List<Section> 시간 남으면 변경
    private static final HashMap<Line, List<Station>> sections = new HashMap<>();
    private static final int MINIMUM_SECTION_SIZE = 2;

    public static Map<Line, List<Station>> stations() {
        return Collections.unmodifiableMap(sections);
    }

    public static void addNewSection(Line line, Station upStation, Station downStation) {
        if (!sections.containsKey(line)) {
            sections.put(line, new ArrayList<>());
        }
        sections.get(line).add(upStation);
        sections.get(line).add(downStation);
    }

    public static void addToSection(Line line, Station station, int order) {
        validateOrderRange(line, order);
        validateDuplication(line, station);
        sections.get(line).add(order - 1, station);
    }

    private static void validateDuplication(Line line, Station station) {
        if (sections.get(line).contains(station)) {
            throw new IllegalArgumentException("이미 노선에 등록되어 있는 역입니다.");
        }
    }

    private static void validateOrderRange(Line line, int order) {
        if (order > sections.get(line).size() || order < 0) {
            throw new IllegalArgumentException("순서를 정확히 입력해주세요.");
        }
    }

    public static boolean has(Line line) {
        return stations().containsKey(line);
    }

    public static boolean has(Station station) {
        for (Line line : sections.keySet()) {
            if (sections.get(line).contains(station)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSectionDeletable(Line line) {
        return sections.get(line).size() > MINIMUM_SECTION_SIZE;
    }

    public static Map<Line, List<Station>> sections() {
        return Collections.unmodifiableMap(sections);
    }

    public static void deleteSection(Line line, Station station) {
        if (!isSectionDeletable(line)) {
            throw new IllegalArgumentException("하나의 노선에는 최소 2개 이상의 역이 등록되어야 합니다.");
        }
        sections.get(line).remove(station);
    }

    public static void deleteLineInSection(Line line) {
        if (!sections.containsKey(line)) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_DOES_NOT_EXIST.toString());
        }
        sections.remove(line);
    }

    public static void initSection(Line line, List<String> stations) {
        sections.put(line, new ArrayList<>());
        stations.stream()
                .map(StationRepository::get)
                .forEach(station -> sections.get(line).add(station));
    }
}

package subway.domain;

import static subway.domain.LineRepository.lines;
import static subway.domain.StationRepository.addStation;
import static subway.domain.StationRepository.stations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class SectionRepository {

    private static final List<List<Station>> sections = new ArrayList<>();

    public static List<List<Station>> sections() {
        return Collections.unmodifiableList(sections);
    }

    //구간 추가
    public static void addSectionStations(List<Station> stations) {
        updateStation(stations);
        sections.add(stations);
    }

    //구간 등록할 때 등록되지 않은 역이 있으면 추가
    public static void updateStation(List<Station> stationList) {
        for (Station station : stationList) {
            if (stations().stream().noneMatch(name -> name.getName().equals(station.getName()))) {
                addStation(station);
            }
        }
    }

    //노선, 순서에 따라 구간 추가
    public static void addSection(int order, Line line, Station station) {
        List<Station> stationList = new ArrayList<>(sections.get(getLineIndex(line)));
        stationList.add(order - 1, station);
        sections.add(getLineIndex(line), stationList);
    }

    //노선의 인덱스 가져오기
    public static int getLineIndex(Line line) {
        return IntStream.range(0, lines().size())
                .filter(i -> lines().get(i)
                        .getName()
                        .equals(line.getName()))
                .findFirst()
                .orElse(-1);
    }

    //모든 노선에서 역이 포함되어 있는지 확인
    public static boolean hasStationOnLine(String station) {
        return sections().toString().contains(station);
    }

    //순서 유효성 확인
    public static void validateOrderRange(int inputStationOrder) {
        if (sections().size() < inputStationOrder) {
            throw new IllegalArgumentException("순서가 잘못되었습니다.");
        }
    }

    //구간 삭제
    public static boolean removeSection(Line removeLine, Station removeStation) {
        int index = getLineIndex(removeLine);
        List<Station> stationList = new ArrayList<>(sections.get(index));
        if (stationList.removeIf(station -> Objects.equals(station.getName(), removeStation.getName()))) {
            sections.add(index, stationList);
            return true;
        }
        return false;
    }

    //구간에 해당하는 역 개수 확인
    public static boolean removeSectionRange(Line inputRemoveLine) {
        return sections.get(getLineIndex(inputRemoveLine)).size() > 2;
    }

    //구간에 이미 포함되어 있는 역인지 확인
    public static boolean hasSectionStation(Line line, Station station) {
        List<Station> stationList = sections.get(getLineIndex(line));
        return stationList.stream()
                .anyMatch(name -> name.getName()
                        .equals(station.getName()));
    }
}

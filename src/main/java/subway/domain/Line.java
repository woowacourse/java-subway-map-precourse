package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private final List<Station> stations = new ArrayList<>();

    public Line(String name) {
        // TODO: 노선 이름에 대한 예외 처리
        this.name = name;
    }

    public static Line createLineWithTerminus(String name, String upstreamTerminus, String downstreamTerminus) {
        Line line = new Line(name);
        line.addStation(StationRepository.getStationByName(upstreamTerminus));
        line.addStation(StationRepository.getStationByName(downstreamTerminus));

        return line;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        // TODO: 중복되는 역 추가 시 예외 처리
        stations.add(station);
    }

    public boolean containsStation(Station station) {
        return containsStation(station.getName());
    }

    public boolean containsStation(String name) {
        return stations.stream()
                .anyMatch(streamStation -> name.equals(streamStation.getName()));
    }
}

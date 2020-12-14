package subway.domain;

import java.util.Arrays;
import java.util.LinkedList;

// 상행, 하행을 포함한 노선의 구간 정보를 가진다.
public class Path {
    private LinkedList<Station> paths;

    public Path(Station... stations) {
        paths = new LinkedList<>(Arrays.asList(stations));
    }

    public Path(LinkedList<Station> paths) {
        this.paths = paths;
    }

    public void initializePath(Station upLine, Station downLine) {
        paths = new LinkedList<>();
        paths.add(downLine);
        paths.add(upLine);
    }

    public void addOneStationBetweenStations(Station station, int index) {
        // 중복 역에 대한 검사는 station을 등록할 때 진행할 것이므로 하지 않아도 됨.
        paths.add(index, station);
    }

    // 상행선의 정보를 전달
    public Station getUpLine() {
        return paths.getFirst();
    }

    public Station getDownLine() {
        return paths.getLast();
    }
}


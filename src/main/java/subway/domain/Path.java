package subway.domain;

import subway.view.OutputView;

import java.util.Arrays;
import java.util.LinkedList;

// 상행, 하행을 포함한 노선의 구간 정보를 가진다.
public class Path {
    private LinkedList<Station> paths;
    private static final int MIN_SIZE = 2;

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
        paths.add(index, station);
    }

    public boolean checkSizeBeforedeleteStation(Station station) {
        if (paths.size() > MIN_SIZE) {
            paths.remove(station);
            return true;
        }
        return false;
    }

    public Station getUpLine() {
        return paths.getFirst();
    }

    public Station getDownLine() {
        return paths.getLast();
    }

    public void printAllPath() {
        for (Station station : paths) {
            OutputView.printWithInformationMark(station.getName());
        }
    }

    public boolean isStationInLine(Station station) {
        return paths.contains(station);
    }
}


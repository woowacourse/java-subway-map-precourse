package subway.domain.path;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class PathRepository {
    private final LinkedList<Station> path = new LinkedList<>();
    private final Set<String> pathStationNames = new HashSet<>();

    public PathRepository(String up, String down) {
        Station upStation = StationRepository.findStation(up);
        Station downStation = StationRepository.findStation(down);
        path.addFirst(upStation);
        path.addLast(downStation);
        upStation.onPath();
        downStation.onPath();
        pathStationNames.add(up);
        pathStationNames.add(down);
    }

    public List<Station> getPath() {
        return Collections.unmodifiableList(path);
    }

    public boolean containsStationName(String station) {
        return pathStationNames.contains(station);
    }

    public void addPath(int index, String newStation) {
        Station station = StationRepository.findStation(newStation);
        path.add(index, station);
        pathStationNames.add(newStation);
    }

    //todo:onPath 문제가 있음.. 다중으로 등록 되어있을때!
    public boolean deletePathByName(String name) {
        StationRepository.findStation(name).onPath();
        pathStationNames.remove(name);
        return path.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public int pathSize() {
        return path.size();
    }


}

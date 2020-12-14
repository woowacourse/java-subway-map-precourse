package subway.domain.path;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class PathRepository {
    private final LinkedList<Station> path = new LinkedList<>();

    public PathRepository(String up, String down) {
        Station upStation = StationRepository.findStation(up);
        Station downStation = StationRepository.findStation(down);
        path.addFirst(upStation);
        path.addLast(downStation);
    }

    public List<Station> getPath() {
        return Collections.unmodifiableList(path);
    }

    public boolean containsStationByName(String stationName) {
        return path.stream().anyMatch(station -> Objects.equals(station.getName(), stationName));
    }

    public void addPath(int index, String newStation) {
        Station station = StationRepository.findStation(newStation);
        path.add(index, station);
    }

    //throw error 처리
    public boolean deletePathByName(String name) {
        return path.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public boolean checkStationOnPathByName(String stationName){
        return path.stream().anyMatch(station -> Objects.equals(station.getName(), stationName));
    }
    public int pathSize() {
        return path.size();
    }


}

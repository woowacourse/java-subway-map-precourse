package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class PathRepository {

    private static final List<Station> path = new LinkedList<>();

    public PathRepository(String up, String down) {
        Station upStation = StationRepository.findStation(up);
        Station downStation = StationRepository.findStation(down);
        path.add(upStation);
        path.add(downStation);
        upStation.onAndOffPath();
        downStation.onAndOffPath();
    }

    public List<Station> getPath() {
        return Collections.unmodifiableList(path);
    }


    public void addPath(int index, Station newStation){
        path.add(index, newStation);
    }

    public boolean deletePathByName(String name){
        StationRepository.findStation(name).onAndOffPath();
        return path.removeIf(station -> Objects.equals(station.getName(), name));
    }

}

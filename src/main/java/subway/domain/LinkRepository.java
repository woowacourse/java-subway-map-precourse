package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LinkRepository {

    private static final List<Station> linkLineStation = new LinkedList<>();

    public LinkRepository(String up, String down) {
        Station upStation = StationRepository.findStation(up);
        Station downStation = StationRepository.findStation(down);
        linkLineStation.add(upStation);
        linkLineStation.add(downStation);
    }

    public List<Station> links() {
        return Collections.unmodifiableList(linkLineStation);
    }


    public void addLink(int index, Station newStation){
        linkLineStation.add(index, newStation);
    }

    public boolean deleteLinkByName(String name){
        return linkLineStation.removeIf(station -> Objects.equals(station.getName(), name));
    }

}

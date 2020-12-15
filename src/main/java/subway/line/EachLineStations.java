package subway.line;

import subway.common.Prefix;
import subway.station.Station;

import java.util.ArrayList;
import java.util.List;

public class EachLineStations {
    private static final String STATION_NUMBER_LACK = Prefix.ERROR.getPrefix() + "등록된 역이 2개 이하이므로 삭제할 수 없습니다.";
    private static final int MIN_ORDER_NUMBER = 1;
    private static final int MIN_STATION_NUMBER = 2;
    private static final int SET_POSITION_INDEX = 1;

    private List<Station> stations;

    public EachLineStations() {
        this.stations = new ArrayList<>();
    }

    public EachLineStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public boolean isRegistered(String name) {
        for (Station station : stations) {
            if (station.isSame(name)) {
                return true;
            }
        }
        return false;
    }

    public void addSection(Station station, int sectionNumber) {
        stations.add(sectionNumber - SET_POSITION_INDEX, station);
    }

    public boolean isNotExistSection(int number) {
        return number < MIN_ORDER_NUMBER || number > stations.size() + SET_POSITION_INDEX;
    }

    public void deleteStation(Station station) {
        if (stations.size() <= MIN_STATION_NUMBER) {
            throw new IllegalArgumentException(STATION_NUMBER_LACK);
        }
        stations.remove(station);
    }
}

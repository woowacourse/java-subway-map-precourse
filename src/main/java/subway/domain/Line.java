package subway.domain;

import java.util.*;

public class Line {
    private static String ERR_OUT_OF_BOUND = "노선의 길이 범위를 벗어나는 순서값입니다.";
    private static String ERR_DUPLICATE_LINE_NAME = "이미 등록된 노선 이름입니다.";
    private static String ERR_DUPLICATE_STATION_IN_LINE = "동일 노선에 동일한 이름의 역입니다.";
    private String name;
    private List<Station> stations;

    public Line(String name, Station... stations) {
        if (LineRepository.isInLineRepository(name)) {
            throw new IllegalArgumentException(ERR_DUPLICATE_LINE_NAME);
        }
        if (!isUnique(stations)){
            throw new IllegalArgumentException(ERR_DUPLICATE_STATION_IN_LINE);
        }
        this.name = name;
        this.stations = new LinkedList<>(Arrays.asList(stations));
    }

    private boolean isUnique(Station[] stations) {
        Set<Station> set = new HashSet<>();
        for(Station s : stations){
            if(set.contains(s)){
                return false;
            }
            set.add(s);
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public int getLength() {
        return stations.size();
    }

    public void add(int index, Station station) {
        try {
            stations.add(index, station);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ERR_OUT_OF_BOUND);
        }
    }

    public boolean remove(Station station) {
        return stations.remove(station);
    }
}

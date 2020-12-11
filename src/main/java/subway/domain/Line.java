package subway.domain;

import subway.dto.LineDTO;
import subway.dto.StationDTO;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String INVALID_LENGTH_FORMAT = "이름은 %d 글자 이상이어야 합니다.";
    private static final String ERROR_ALREADY_EXIST = "이미 노선에 등록된 역입니다.";
    private static final int MIN_LENGTH = 2;

    private String name;
    private List<Station> stations;

    public Line(String name) {
        if (name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_LENGTH_FORMAT, MIN_LENGTH));
        }
        this.name = name;
        this.stations = new ArrayList<>();
    }

    public void addStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException(ERROR_ALREADY_EXIST);
        }
        stations.add(station);
    }

    public String getName() {
        return name;
    }

    public LineDTO toDTO() {
        List<StationDTO> stations = new ArrayList<>();
        for (Station station: this.stations) {
            stations.add(station.toDTO());
        }
        return new LineDTO(this.name, stations);
    }

    // 추가 기능 구현
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Line paramObj = (Line) obj;
        return this.name.equals(paramObj.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}

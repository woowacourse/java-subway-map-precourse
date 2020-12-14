package subway.domain;

import subway.dto.LineDTO;
import subway.dto.StationDTO;
import subway.exception.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line {
    private static final String INVALID_LENGTH_FORMAT = "이름은 %d 글자 이상이어야 합니다.";
    private static final String ERROR_ALREADY_EXIST = "이미 노선에 등록된 역입니다.";
    private static final String ERROR_OUT_OF_RANGE = "구간 범위를 벗어났습니다.";
    private static final String ERROR_MIN_LENGTH = "이하 길이의 구간에서는 삭제할 수 없습니다.";
    private static final String ERROR_NOT_EXIST = "해당 구간에 등록되지 않은 역입니다.";
    private static final int MIN_LENGTH = 2;
    private static final int GAP = 1;
    private static final int ZERO = 0;

    private String name;
    private List<Station> stations;

    public Line(String name, Station upLineStation, Station downLineStation) {
        if (name.length() < MIN_LENGTH) {
            throw new InvalidInputLengthException(String.format(INVALID_LENGTH_FORMAT, MIN_LENGTH));
        }
        this.name = name;
        this.stations = new ArrayList<>(Arrays.asList(upLineStation, downLineStation));
    }

    public void addStation(int index, Station station) {
        if (stations.size() + GAP < index || index < ZERO) {
            throw new OutOfRangeException(ERROR_OUT_OF_RANGE);
        }
        if (contains(station)) {
            throw new DuplicatedObjectException(ERROR_ALREADY_EXIST);
        }
        stations.add(index - GAP, station);
    }

    public void deleteStation(Station station) {
        if (stations.size() <= MIN_LENGTH) {
            throw new InsufficientItemsLengthException(MIN_LENGTH + ERROR_MIN_LENGTH);
        }
        boolean removed = stations.remove(station);
        if (!removed) {
            throw new NoSuchObjectException(ERROR_NOT_EXIST);
        }
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

    public boolean contains(Station station) {
        return stations.contains(station);
    }

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

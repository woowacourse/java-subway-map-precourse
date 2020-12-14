package subway.domain;

import java.util.Objects;

import static subway.repository.StationRepository.addStation;
import static subway.view.OutputView.warnMessage;

public class Station {
    private static final String STATION_NAME_LENGTH_WARN = "역 이름은 2글자 이상이어야 합니다.";

    private final String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    public static void createStation(String stationName) {
        if (stationName.length() < 2) {
            warnMessage(STATION_NAME_LENGTH_WARN);
            return;
        }
        addStation(new Station(stationName));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Station) {
            Station station = (Station) obj;
            return this.name.equals(station.name);
        }
        return false;
    }
}

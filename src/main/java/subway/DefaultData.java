package subway;

import subway.domain.Station;
import subway.domain.StationRepository;

public class DefaultData {
    public static void input(){
        Constant.defaultStationList().forEach(station -> {
            StationRepository.addStation(new Station(station));
        });
    }
}

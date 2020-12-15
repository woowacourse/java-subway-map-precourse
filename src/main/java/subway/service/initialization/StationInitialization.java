package subway.service.initialization;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.type.StationType;

/**
 * StationInitialization.java : 지하철 역 초기화에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class StationInitialization {
    public static void initializeStations() {
        StationRepository.addStation(new Station(StationType.EDUCATION_UNIVERSITY.getStation()));
        StationRepository.addStation(new Station(StationType.GANGNAM.getStation()));
        StationRepository.addStation(new Station(StationType.YEOKSAM.getStation()));
        StationRepository.addStation(new Station(StationType.NAMBU_BUS_TERMINAL.getStation()));
        StationRepository.addStation(new Station(StationType.YANGJAE.getStation()));
        StationRepository.addStation(new Station(StationType.YANGJAE_CITIZENS_FOREST.getStation()));
        StationRepository.addStation(new Station(StationType.MAEBONG.getStation()));
    }
}

package subway.service.initialization;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.type.StationType;

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

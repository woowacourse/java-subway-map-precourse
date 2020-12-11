package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.type.InputType;
import subway.type.StationType;

public class StationService {
    public static void initializeStations() {
        StationRepository.addStation(new Station(StationType.EDUCATION_UNIVERSITY.getStation()));
        StationRepository.addStation(new Station(StationType.GANGNAM.getStation()));
        StationRepository.addStation(new Station(StationType.YEOKSAM.getStation()));
        StationRepository.addStation(new Station(StationType.NAMBU_BUS_TERMINAL.getStation()));
        StationRepository.addStation(new Station(StationType.YANGJAE.getStation()));
        StationRepository.addStation(new Station(StationType.YANGJAE_CITIZENS_FOREST.getStation()));
        StationRepository.addStation(new Station(StationType.MAEBONG.getStation()));
    }

    public static boolean isStationInput(String stationInput) {
        if (stationInput.equals(InputType.INPUT_ONE.getInput())) {
            return true;
        }
        if (stationInput.equals(InputType.INPUT_TWO.getInput())) {
            return true;
        }
        if (stationInput.equals(InputType.INPUT_THREE.getInput())) {
            return true;
        }
        return stationInput.equals(InputType.INPUT_BACK.getInput());
    }
}

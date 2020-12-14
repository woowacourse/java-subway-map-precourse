package subway.service;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exceptions.DuplicatedStationNameException;
import subway.exceptions.StationNotExistException;

import java.util.List;
import java.util.Optional;

public class StationService {
    public static List<Station> getStations(){
        return StationRepository.getStations();
    }

    public static Optional<Station> getStation(String name){
        return StationRepository.getStation(name);
    }

    public static void addStation(String name){
        if(checkIfStationExist(name)) {
            throw new DuplicatedStationNameException();
        }
        Station newStation = new Station(name);
        StationRepository.addStation(newStation);
    }

    public static void removeStation(String name){
        if(!checkIfStationExist(name)){
            throw new StationNotExistException();
        }
        Station station = StationRepository.getStation(name).get();
        LineRepository.deleteStationInLines(station);
        StationRepository.deleteStation(name);
    }

    private static boolean checkIfStationExist(String name){
        if(StationRepository.getStation(name).isPresent()){
            return true;
        }
        return false;
    }
}

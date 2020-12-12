package subway.controller;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exceptions.DuplicatedStationNameException;
import subway.exceptions.StationNotExistException;

import java.util.List;
import java.util.Optional;

public class StationController {
    private static StationController stationController;

    private StationController(){
    }

    public static synchronized StationController getStationController(){
        if(!Optional.ofNullable(stationController).isPresent()){
            stationController = new StationController();
        }
        return stationController;
    }

    public List<Station> getStations(){
        return StationRepository.getStations();
    }

    public Station getStation(String name) throws StationNotExistException {
        Optional<Station> stationOptional = StationRepository.getStation(name);
        if(!stationOptional.isPresent()){
            throw new StationNotExistException();
        }
        return stationOptional.get();
    }

    public void addStation(String name) throws DuplicatedStationNameException {
        if(checkIfStationExist(name)) {
            throw new DuplicatedStationNameException();
        }
        Station newStation = new Station(name);
        StationRepository.addStation(newStation);
    }

    public void removeStation(String name) throws StationNotExistException {
        if(!checkIfStationExist(name)){
            throw new StationNotExistException();
        }
        Station station = StationRepository.getStation(name).get();
        LineRepository.deleteStationInLines(station);
        StationRepository.deleteStation(name);
    }

    private boolean checkIfStationExist(String name){
        if(StationRepository.getStation(name).isPresent()){
            return true;
        }
        return false;
    }
}

package subway.controller;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exceptions.AlreadyAddedInLineException;
import subway.exceptions.StationNameLengthException;
import subway.exceptions.StationNotExistException;
import subway.exceptions.StationNotExistInLineException;
import subway.service.LineService;
import subway.service.StationService;

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
        return StationService.getStations();
    }

    public Station getStation(String name){
        Optional<Station> stationOptional = StationService.getStation(name);
        if(!stationOptional.isPresent()){
            throw new StationNotExistException();
        }
        return stationOptional.get();
    }

    public void addStation(String name){
        if(name.length() < 2){
            throw new StationNameLengthException();
        }
        StationService.addStation(name);
    }

    public void removeStation(String name){
        Optional<Station> stationOptional = LineService.getStationInLine(name);
        if(stationOptional.isPresent()){
            throw new AlreadyAddedInLineException();
        }
        StationService.removeStation(name);
    }
}
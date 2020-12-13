package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.exceptions.*;

import java.util.List;
import java.util.Optional;

public class LineController {
    private static LineController lineController;

    private LineController(){
    }

    public static synchronized LineController getLineController(){
        if(!Optional.ofNullable(lineController).isPresent()){
            lineController = new LineController();
        }
        return lineController;
    }

    public List<Line> getLines(){
        return LineRepository.getLines();
    }

    public Optional<Line> getLine(String lineName){
        return LineRepository.getLine(lineName);
    }

    public void addLine(String name, Station startStation, Station endStation){
        if(checkIfLineExist(name)) {
            throw new DuplicatedLineNameException();
        }
        Line line = new Line(name);
        line.addStation(0, startStation);
        line.addStation(1, endStation);
        LineRepository.addLine(line);
    }

    public void removeLine(String name){
        if(!checkIfLineExist(name)) {
            throw new LineNotExistException();
        }
        LineRepository.deleteLineByName(name);
    }

    public void addStationInLineAtCertainPosition(Station station, Line line, int position){
        if(position > line.getStations().size() || position < 0){
            throw new InvalidPositionException();
        }
        line.addStation(position, station);
    }

    public boolean checkIfLineExist(String name){
        if(LineRepository.getLine(name).isPresent()){
            return true;
        }
        return false;
    }
}

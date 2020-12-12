package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.exceptions.DuplicatedLineNameException;
import subway.exceptions.DuplicatedStartAndEndStationNameException;

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

    public void addLine(String name, Station startStation, Station endStation) throws Exception {
        if(checkIfLineExist(name)) {
            throw new DuplicatedLineNameException();
        }
        if(startStation.getName().equals(endStation.getName())){
            throw new DuplicatedStartAndEndStationNameException();
        }
        Line line = new Line(name);
        line.addStation(startStation);
        line.addStation(endStation);
        LineRepository.addLine(line);
    }

    public void removeLine(String name){
        LineRepository.deleteLineByName(name);
    }

    public boolean checkIfLineExist(String name){
        if(LineRepository.getLine(name).isPresent()){
            return true;
        }
        return false;
    }
}

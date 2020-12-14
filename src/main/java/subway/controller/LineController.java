package subway.controller;

import subway.domain.Line;
import subway.domain.Station;
import subway.exceptions.LineNotExistException;
import subway.service.LineService;

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
        return LineService.getLines();
    }

    public Line getLine(String lineName){
        Optional<Line> lineOptional = LineService.getLine(lineName);
        if(!lineOptional.isPresent()){
            throw new LineNotExistException();
        }
        return lineOptional.get();
    }

    public void addLine(String name, Station startStation, Station endStation){
        LineService.addLine(name, startStation, endStation);
    }

    public void removeLine(String name){
        LineService.removeLine(name);
    }

    public void addStationInLine(Station station, Line line, int position){
        LineService.addStationInLine(station, line, position);
    }

    public void removeStationInLine(Station station, Line line){
        LineService.removeStationInLine(station, line);
    }

    public boolean isExistingLineName(String name){
        Optional<Line> lineOptional = LineService.getLine(name);
        if(lineOptional.isPresent()){
            return true;
        }
        return false;
    }
}

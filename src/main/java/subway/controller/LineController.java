package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.exceptions.DuplicatedLineNameException;
import subway.view.SectionManagementViewState;

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

    public void addLine(String name) throws DuplicatedLineNameException {
        if(checkIfLineExist(name)) {
            throw new DuplicatedLineNameException();
        }
        LineRepository.addLine(new Line(name));
    }

    public boolean checkIfLineExist(String name){
        if(LineRepository.getLine(name).isPresent()){
            return true;
        }
        return false;
    }
}

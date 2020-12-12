package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
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
}

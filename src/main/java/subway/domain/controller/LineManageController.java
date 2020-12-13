package subway.domain.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.input.LineManageInput;

import java.util.Scanner;

public class LineManageController {

    LineManageInput input = new LineManageInput();

    public void processEnrollLine(Scanner scanner) {
        Line line = new Line(input.inputEnrollLine(scanner));
        LineRepository.addLine(line);
    }

    public void processDeleteLine(Scanner scanner) {
        String line = input.inputDeleteLine(scanner);
        LineRepository.deleteLineByName(line);
    }

    public void processUpDownTrain(Scanner scanner, Line line) {
        Station train = input.inputUpDownTrainLine(scanner);
        line.addStation(train);
    }

}

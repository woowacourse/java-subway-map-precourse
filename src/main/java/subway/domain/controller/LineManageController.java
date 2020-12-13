package subway.domain.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.input.LineManageInput;

import java.util.Scanner;
import java.util.stream.Stream;

public class LineManageController {

    LineManageInput input = new LineManageInput();

    public void processEnrollLine(Line line) {
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

    public void printAllLines() {
        Stream<Line> lineStream = LineRepository.lines().stream();
        lineStream.forEach(line -> System.out.println(line.getName()));
    }

}

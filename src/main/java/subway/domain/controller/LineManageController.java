package subway.domain.controller;

import subway.domain.ErrorMessage;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.input.LineManageInput;

import java.util.Scanner;
import java.util.stream.Stream;

public class LineManageController {

    static final String INFO = "[INFO] ";

    LineManageInput input = new LineManageInput();

    public Line processEnrollLine(Line line) {
        LineRepository.addLine(line);
        return line;
    }

    public void processDeleteLine(Scanner scanner) {
        String line = input.inputDeleteLine(scanner);
        LineRepository.deleteLineByName(line);
    }

    public void processUpDownTrain(Station station, Line line) {
        line.addStation(station);
        station.addLine(line);
    }

    public void checkTwoTrainSame(Station upTrain, Station downTrain) throws IllegalArgumentException{
        if (upTrain.equals(downTrain)) {
            ErrorMessage.isTwoTrainNameSame();
            throw new IllegalArgumentException();
        }
    }

    public void printAllLines() {
        Stream<Line> lineStream = LineRepository.lines().stream();
        lineStream.forEach(line -> System.out.println(INFO + line.getName()));
    }

}

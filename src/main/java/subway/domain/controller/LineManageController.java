package subway.domain.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.input.LineManageInput;

import java.util.Scanner;

public class LineManageController {

    LineManageInput input = new LineManageInput();

    public void processEnrollLine(Scanner scanner) {
        Line line = new Line(input.inputEnrollLine(scanner));
        LineRepository.addLine(line);
    }

}

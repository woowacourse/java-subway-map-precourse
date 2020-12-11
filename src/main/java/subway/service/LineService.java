package subway.service;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.type.InputType;
import subway.type.LineType;

public class LineService {
    public static void initializeLines() {
        LineRepository.addLine(new Line(LineType.TWO.getLine()));
        LineRepository.addLine(new Line(LineType.THREE.getLine()));
        LineRepository.addLine(new Line(LineType.SHINBUNDANG.getLine()));
    }

    public static boolean isLineInput(String lineInput) {
        if (lineInput.equals(InputType.INPUT_ONE.getInput())) {
            return true;
        }
        if (lineInput.equals(InputType.INPUT_TWO.getInput())) {
            return true;
        }
        if (lineInput.equals(InputType.INPUT_THREE.getInput())) {
            return true;
        }
        return lineInput.equals(InputType.INPUT_BACK.getInput());
    }
}

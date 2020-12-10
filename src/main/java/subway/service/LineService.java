package subway.service;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.type.LineType;

public class LineService {
    public static void initializeLines() {
        LineRepository.addLine(new Line(LineType.TWO.getLine()));
        LineRepository.addLine(new Line(LineType.THREE.getLine()));
        LineRepository.addLine(new Line(LineType.SHINBUNDANG.getLine()));
    }
}

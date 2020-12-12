package subway.service.initialization;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.type.LineType;

public class LineInitialization {
    public static void initializeLines() {
        LineRepository.addLine(new Line(LineType.TWO.getLine()));
        LineRepository.addLine(new Line(LineType.THREE.getLine()));
        LineRepository.addLine(new Line(LineType.SHINBUNDANG.getLine()));
    }
}

package subway.service.initialization;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.type.LineType;

/**
 * LineInitialization.java : 지하철 노선 초기화에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class LineInitialization {
    public static void initializeLines() {
        LineRepository.addLine(new Line(LineType.TWO.getLine()));
        LineRepository.addLine(new Line(LineType.THREE.getLine()));
        LineRepository.addLine(new Line(LineType.SHINBUNDANG.getLine()));
    }
}

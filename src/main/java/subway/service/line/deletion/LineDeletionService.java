package subway.service.line.deletion;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.repository.TransitMapRepository;
import subway.view.output.line.LineInformationView;

import java.util.List;

/**
 * LineDeletionService.java : 지하철 노선 삭제 로직에 대한 서비스 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class LineDeletionService {
    public static Line getLineForDeletion(String lineName) {
        Line lineForDeletion = new Line(lineName);
        List<Line> lines = LineRepository.lines();

        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                lineForDeletion = line;
                break;
            }
        }
        return lineForDeletion;
    }

    public static void deleteLineInTransitMap(Line lineForDeletion) {
        TransitMapRepository.deleteTransitMap(lineForDeletion);
        LineInformationView.printLineDeletionInformation();
        System.out.println();
    }
}

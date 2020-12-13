package subway.service.line;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.repository.TransitMapRepository;
import subway.view.output.line.LineInformationView;

import java.util.List;

public class LineNameDeletionService {
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

    public static void deleteName(Line lineForDeletion) {
        TransitMapRepository.deleteTransitMap(lineForDeletion);
        LineInformationView.printLineDeletionInformation();
        System.out.println();
    }
}

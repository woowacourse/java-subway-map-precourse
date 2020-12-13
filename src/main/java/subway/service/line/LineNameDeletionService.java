package subway.service.line;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.repository.TransitMapRepository;

import java.util.List;

public class LineNameDeletionService {
    public static void deleteLineName(String lineName) {
        List<Line> lines = LineRepository.lines();

        for (Line lineForDeletion : lines) {
            String lineNameForDeletion = lineForDeletion.getName();

            if (lineNameForDeletion.equals(lineName)) {
                TransitMapRepository.deleteTransitMap(lineForDeletion);
            }
        }
    }
}

package subway.service.lineservice;

import subway.repository.LineRepository;
import subway.views.lineviews.LineOutputView;

public class LinesPrintService {
    public static void showAllLines() {
        LineOutputView.printLines(LineRepository.lines());
    }
}

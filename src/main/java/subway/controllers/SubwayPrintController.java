package subway.controllers;

import subway.domain.Line;
import subway.domain.SectionRepository;
import subway.domain.Station;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class SubwayPrintController {

    public static void run() {
        OutputView.printSubwayPrintController();
        Map<Line, List<Station>> sections = SectionRepository.sections();
        for (Line line : sections.keySet()) {
            OutputView.printWithInfo(line.getName());
            OutputView.printSeperateLine();
            sections.get(line).stream()
                    .map(station -> station.getName())
                    .forEach(OutputView::printWithInfo);
            OutputView.printNewLine();
        }
    }
}

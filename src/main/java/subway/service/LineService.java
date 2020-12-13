package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.LineDisplay;

public class LineService {
    public static void save(String lineName) {
        Line newLine = Line.newLineWithName(lineName);
        LineRepository.addLine(newLine);
        SectionService.save(newLine);
        LineDisplay.printSaveSuccess();
    }

    public static void delete(String lineName) {
        SectionService.delete(lineName);
        LineRepository.deleteLine(lineName);
        LineDisplay.printDeleteSuccess();
    }

    public static void print() {
        LineDisplay.printAllLines(LineRepository.lines());
    }
}

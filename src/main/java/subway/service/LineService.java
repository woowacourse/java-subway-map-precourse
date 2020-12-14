package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.LineDisplay;
import subway.view.UserInput;

public class LineService {

    public static void saveLine() {
        Line newLine = Line.newLineWithName(UserInput.getSaveLineName());
        LineRepository.validateNameDuplicate(newLine);
        SectionService.saveSection(newLine);
        LineRepository.addLine(newLine);
        LineDisplay.printSaveSuccess();
    }

    public static void deleteLine() {
        String lineName = UserInput.getDeleteLineName();
        SectionService.deleteSection(lineName);
        LineRepository.deleteLine(lineName);
        LineDisplay.printDeleteSuccess();
    }

    public static void printLines() {
        LineDisplay.printAllLines(LineRepository.lines());
    }
}

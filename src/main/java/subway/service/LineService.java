package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.LineDisplay;
import subway.view.UserInput;

public class LineService {

    public static void saveLine() {
        StationService.validateEnoughStations();
        Line newLine = Line.newLineWithName(UserInput.getSaveLineName());
        LineRepository.validateNameDuplicate(newLine);
        SectionService.saveSection(newLine);
        LineRepository.addLine(newLine);
        LineDisplay.printSaveSuccess();
    }

    public static void deleteLine() {
        LineRepository.validateLinesEmpty();
        String lineName = UserInput.getDeleteLineName();
        SectionService.deleteSection(lineName);
        LineRepository.deleteLine(lineName);
        LineDisplay.printDeleteSuccess();
    }

    public static void printLines() {
        LineRepository.validateLinesEmpty();
        LineDisplay.printAllLines(LineRepository.lines());
    }
}

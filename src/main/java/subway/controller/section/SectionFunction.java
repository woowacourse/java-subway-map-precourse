package subway.controller.section;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.exception.*;
import subway.utils.InputValidator;
import subway.view.InputView;
import subway.view.outputview.SectionOutputView;

public class SectionFunction {
    public static Object add(Object nothing) {
        try {
            String line = inputAddLine();
            String station = inputAddStation(line);
            String order = inputAddOrder(line);
            LineRepository.addSection(line, station, order);
            SectionOutputView.successAdd();
        } catch (NullPointerException e) {

        }
        return null;
    }

    private static String inputAddLine() {
        try {
            SectionOutputView.registerSectionLineName();
            String line = InputView.input();
            InputValidator.validLineName(line);
            LineRepository.notExistLineName(line);
            LineRepository.twoMoreLines(line);
            return line;
        } catch (InvalidLineNameException | NotExistLineException | InvalidLineLengthException e) {
            throw new NullPointerException();
        }
    }

    private static String inputAddStation(String line) {
        try {
            SectionOutputView.registerSectionStationName();
            String station = InputView.input();
            InputValidator.validStationName(station);
            StationRepository.notExistStationName(station);
            LineRepository.duplicateStationSelectLine(station, line);
            return station;
        } catch (InvalidStationNameException | NotExistStationException | DuplicateStationOfLineException e) {
            throw new NullPointerException();
        }
    }

    private static String inputAddOrder(String line) {
        try {
            SectionOutputView.registerSectionOrder();
            String order = InputView.input();
            InputValidator.validSectionOrder(order);
            LineRepository.validOrderLength(line, order);
            return order;
        } catch (InvalidOrderException | InvalidOrderLengthException e) {
            throw new NullPointerException();
        }
    }

    public static Object delete(Object o) {
        return null;
    }
}

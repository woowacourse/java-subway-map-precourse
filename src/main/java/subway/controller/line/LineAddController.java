package subway.controller.line;

import static subway.exception.ExceptionMessage.INVALID_ADD_LINE_ALREADY_EXISTS;
import static subway.exception.ExceptionMessage.INVALID_ADD_LINE_NAME;
import static subway.exception.ExceptionMessage.INVALID_ADD_LINE_NAME_CHARACTER;
import static subway.exception.ExceptionMessage.INVALID_ADD_LINE_NAME_SUFFIX;
import static subway.exception.ExceptionMessage.INVALID_ADD_LINE_NOT_FOUND_STATION;
import static subway.util.Retry.retry;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class LineAddController implements SubLineController {
    private static final int MIN_LINE_NAME_LENGTH = 2;
    private static final char MIN_NUMBER_LINE_NAME_CHARACTER = '0';
    private static final char MAX_NUMBER_LINE_NAME_CHARACTER = '9';
    private static final char MIN_KOREAN_LINE_NAME = '가';
    private static final char MAX_KOREAN_LINE_NAME = '힣';
    private static final String LINE_NAME_SUFFIX = "선";
    private final InputView inputView;
    private final OutputView outputView;

    public LineAddController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public LineOption process() {
        try {
            String lineName = retry(this::getLineName);
            Station ascendingStation = getAscendingStation();
            Station descendingStation = getDescendingStation();
            LineRepository.addLine(new Line(lineName, ascendingStation, descendingStation));
            outputView.printAddLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return LineOption.ADD;
    }

    private String getLineName() {
        String lineName = inputView.readAddLine();
        if (LineRepository.containsLineName(lineName)) {
            throw new IllegalArgumentException(INVALID_ADD_LINE_ALREADY_EXISTS.getMessage());
        }
        if (lineName.length() < MIN_LINE_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_ADD_LINE_NAME.getMessage());
        }
        if (lineName.chars()
                .anyMatch(character ->
                        (character < MIN_NUMBER_LINE_NAME_CHARACTER || MAX_NUMBER_LINE_NAME_CHARACTER < character) && (
                                character < MIN_KOREAN_LINE_NAME
                                        || MAX_KOREAN_LINE_NAME < character))) {
            throw new IllegalArgumentException(INVALID_ADD_LINE_NAME_CHARACTER.getMessage());
        }
        if (!lineName.endsWith(LINE_NAME_SUFFIX)) {
            throw new IllegalArgumentException(INVALID_ADD_LINE_NAME_SUFFIX.getMessage());
        }
        return lineName;
    }

    private Station getAscendingStation() {
        Station ascendingStation = inputView.readAscendingStation();
        if (!validateStationExist(ascendingStation)) {
            throw new IllegalArgumentException(INVALID_ADD_LINE_NOT_FOUND_STATION.getMessage());
        }
        return ascendingStation;
    }

    private Station getDescendingStation() {
        Station descendingStation = inputView.readDescendingStation();
        if (!validateStationExist(descendingStation)) {
            throw new IllegalArgumentException(INVALID_ADD_LINE_NOT_FOUND_STATION.getMessage());
        }
        return descendingStation;
    }

    private static boolean validateStationExist(Station station) {
        return LineRepository.containsStation(station);
    }
}

package subway.controller.line;

import static subway.exception.ExceptionMessage.INVALID_ADD_LINE_NOT_FOUND_STATION;
import static subway.util.Retry.retry;
import static subway.util.SubwayValidator.validateExistLine;
import static subway.util.SubwayValidator.validateLineNameCharacter;
import static subway.util.SubwayValidator.validateLineNameLength;
import static subway.util.SubwayValidator.validateLineNameSuffix;

import subway.controller.SubController;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class LineAddController implements SubController {
    private final InputView inputView;
    private final OutputView outputView;

    public LineAddController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        try {
            Line line = new Line(retry(this::getLineName));
            LineRepository.addLine(line);
            SectionRepository.createSection(line, getAscendingStation(), getDescendingStation());
            outputView.printAddLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private String getLineName() {
        String lineName = inputView.readAddLine();
        return validate(lineName);
    }

    private static String validate(String lineName) {
        validateExistLine(lineName);
        validateLineNameLength(lineName);
        validateLineNameCharacter(lineName);
        validateLineNameSuffix(lineName);
        return lineName;
    }

    private Station getAscendingStation() {
        Station ascendingStation = inputView.readAscendingStation();
        validateStationExist(ascendingStation);
        return ascendingStation;
    }

    private Station getDescendingStation() {
        Station descendingStation = inputView.readDescendingStation();
        validateStationExist(descendingStation);
        return descendingStation;
    }

    private static void validateStationExist(Station descendingStation) {
        if (!StationRepository.contains(descendingStation)) {
            throw new IllegalArgumentException(INVALID_ADD_LINE_NOT_FOUND_STATION.getMessage());
        }
    }
}

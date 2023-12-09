package subway.controller.section;

import static subway.exception.ExceptionMessage.NOT_FOUND_LINE;
import static subway.exception.ExceptionMessage.NOT_FOUND_STATION;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionRemoveController implements SubSectionController {
    private final InputView inputView;
    private final OutputView outputView;

    public SectionRemoveController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public SectionOption process() {
        try {
            Line line = getLine();
            Station station = getStation(line);
            line.removeSection(station);
            outputView.printRemoveSection();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return SectionOption.DELETE;
    }

    private Line getLine() {
        String lineName = inputView.readRemoveSectionLine();
        if (!LineRepository.containsLineName(lineName)) {
            throw new IllegalArgumentException(NOT_FOUND_LINE.getMessage());
        }
        Line line = LineRepository.findLineByName(lineName);
        return line;
    }

    private Station getStation(Line line) {
        Station station = inputView.readRemoveSectionStation();
        if (!line.contains(station)) {
            throw new IllegalArgumentException(NOT_FOUND_STATION.getMessage());
        }
        return station;
    }
}

package subway.controller.section;

import static subway.util.SubwayValidator.validateLineExist;
import static subway.util.SubwayValidator.validateSectionExist;

import subway.controller.SubController;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionRemoveController implements SubController {
    private final InputView inputView;
    private final OutputView outputView;

    public SectionRemoveController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        try {
            SectionRepository.removeSection(getLine(), getStation(getLine()));
            outputView.printRemoveSection();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private Line getLine() {
        String lineName = inputView.readRemoveSectionLine();
        validateLineExist(lineName);
        return LineRepository.findLineByName(lineName);
    }

    private Station getStation(Line line) {
        Station station = inputView.readRemoveSectionStation();
        validateSectionExist(line, station);
        return station;
    }
}

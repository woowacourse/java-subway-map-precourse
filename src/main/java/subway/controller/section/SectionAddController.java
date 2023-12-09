package subway.controller.section;

import static subway.util.SubwayValidator.validateLineExist;
import static subway.util.SubwayValidator.validateStationExist;

import subway.controller.SubController;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionAddController implements SubController {
    private final InputView inputView;
    private final OutputView outputView;

    public SectionAddController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        try {
            SectionRepository.addSection(getLine(), getStation(), getIndex());
            outputView.printAddSection();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private Line getLine() {
        String lineName = inputView.readAddSectionLine();
        validateLineExist(lineName);
        return LineRepository.findLineByName(lineName);
    }

    private Station getStation() {
        Station station = inputView.readAddSectionStation();
        validateStationExist(station);
        return station;
    }

    private int getIndex() {
        return inputView.readAddSectionIndex();
    }
}

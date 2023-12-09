package subway.controller.section;

import static subway.exception.ExceptionMessage.NOT_FOUND_LINE;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionAddController implements SubSectionController {
    private final InputView inputView;
    private final OutputView outputView;

    public SectionAddController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public SectionOption process() {
        try {
            String lineName = inputView.readAddSectionLine();
            if (!LineRepository.containsLineName(lineName)) {
                throw new IllegalArgumentException(NOT_FOUND_LINE.getMessage());
            }
            Station station = inputView.readAddSectionStation();
            int index = inputView.readAddSectionIndex();
            Line line = LineRepository.findLineByName(lineName);
            line.addSection(station, index);
            outputView.printAddSection();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return SectionOption.ADD;
    }
}

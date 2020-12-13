package subway.controller.section;

import subway.controller.Controller;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionAddController implements Controller {

    private final InputView inputView;

    public SectionAddController(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public void run() {
        try {
            String targetLine = inputView.inputName(InputView.CHOOSE_LINE);
            String targetStation = inputView.inputName(InputView.CHOOSE_STATION_NAME);
            String index = inputView.inputIndex(InputView.CHOOSE_ORDER);
            Line modifyingLine = LineRepository.get(targetLine);
            Station addingStation = StationRepository.get(targetStation);
            modifyingLine.add(index, addingStation);

            OutputView.printInfo(OutputView.INFO_SECTION_ADD);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }
}

package subway.controller.section;

import subway.controller.Controller;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.view.InfoMessage;
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
            Line modifyingLine = LineRepository.get(targetLine);

            String targetStation = inputView.inputName(InputView.CHOOSE_STATION_NAME);
            Station addingStation = StationRepository.get(targetStation);

            String index = inputView.inputIndex(InputView.CHOOSE_ORDER);
            modifyingLine.addStationAtSection(index, addingStation);
            OutputView.printInfo(InfoMessage.SECTION_ADDED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }
}

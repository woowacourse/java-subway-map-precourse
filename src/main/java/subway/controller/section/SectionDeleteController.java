package subway.controller.section;

import subway.controller.Controller;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.view.InfoMessage;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionDeleteController implements Controller {

    private final InputView inputView;

    public SectionDeleteController(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public void run() {
        try {
            String targetLine = inputView.inputName(InputView.CHOOSE_LINE);
            Line modifyingLine = LineRepository.get(targetLine);

            String targetStation = inputView.inputName(InputView.CHOOSE_STATION_NAME);
            Station deletingStation = StationRepository.get(targetStation);

            modifyingLine.remove(deletingStation);
            OutputView.printInfo(InfoMessage.SECTION_DELETED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }
}

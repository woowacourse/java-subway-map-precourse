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
            getModifyingLine().remove(getDeletingStation());
            OutputView.printInfo(InfoMessage.SECTION_DELETED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }

    private Line getModifyingLine() {
        String modifyingLineName = inputView.inputName(InputView.CHOOSE_SECTION_DELETE_LINE);
        return LineRepository.get(modifyingLineName);
    }

    private Station getDeletingStation() {
        String deletingStationName = inputView.inputName(InputView.CHOOSE_SECTION_DELETE_STATION);
        return StationRepository.get(deletingStationName);
    }
}

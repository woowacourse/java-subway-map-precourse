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
            getModifyingLine().addStationAtSection(getAddingStation(), getStringIndex());
            OutputView.printInfo(InfoMessage.SECTION_ADDED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }

    private Line getModifyingLine() {
        String modifyingLineName = inputView.inputName(InputView.CHOOSE_SECTION_ADD_LINE);
        return LineRepository.get(modifyingLineName);
    }

    private Station getAddingStation() {
        String addingStationName = inputView.inputName(InputView.CHOOSE_SECTION_ADD_STATION);
        return StationRepository.get(addingStationName);
    }

    private String getStringIndex() {
        return inputView.inputIndex(InputView.CHOOSE_SECTION_ADD_ORDER);
    }
}

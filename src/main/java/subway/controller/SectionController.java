package subway.controller;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController extends Controller {

    private static final int ADD_SECTION = 1;
    private static final int DELETE_SECTION = 2;

    public SectionController(InputView inputView) {
        super(inputView);
    }

    @Override
    public void run() {
        try {
            String functionDecision = inputView.inputFunction(Function.SECTION_MENU);
            if (Function.isExitDecision(functionDecision, Function.SECTION_MENU)) {
                return;
            }
            Function.validate(functionDecision, Function.SECTION_MENU);
            goTo(Integer.parseInt(functionDecision));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            run();
        }
    }

    private void goTo(int function) {
        if (function == ADD_SECTION) {
            addSection();
        }
        if (function == DELETE_SECTION) {
            deleteSection();
        }
    }

    private void addSection() {
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

    private void deleteSection() {
        try {
            String targetLine = inputView.inputName(InputView.CHOOSE_LINE);
            String targetStation = inputView.inputName(InputView.CHOOSE_STATION_NAME);
            Line modifyingLine = LineRepository.get(targetLine);
            Station deletingStation = StationRepository.get(targetStation);
            modifyingLine.remove(deletingStation);

            OutputView.printInfo(OutputView.INFO_SECTION_DELETE);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }
}

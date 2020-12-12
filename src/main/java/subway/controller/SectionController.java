package subway.controller;

import subway.domain.line.LineRepository;
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
            int index = inputView.inputIndex(InputView.CHOOSE_ORDER);
            LineRepository.addSection(targetLine, targetStation, index);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }

    private void deleteSection() {
        try {
            String targetLine = inputView.inputName(InputView.CHOOSE_LINE);
            String targetStation = inputView.inputName(InputView.CHOOSE_STATION_NAME);
            LineRepository.deleteSection(targetLine, targetStation);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }
}

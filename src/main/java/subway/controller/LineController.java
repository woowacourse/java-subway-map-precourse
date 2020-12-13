package subway.controller;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController extends Controller {

    private static final int ADD_FUNCTION = 1;
    private static final int DELETE_FUNCTION = 2;
    private static final int VIEW_FUNCTION = 3;

    public LineController(InputView inputView) {
        super(inputView);
    }

    @Override
    public void run() {
        try {
            String functionDecision = inputView.inputFunction(Function.LINE_MENU);
            if (Function.isExitDecision(functionDecision, Function.LINE_MENU)) {
                return;
            }
            Function.validate(functionDecision, Function.LINE_MENU);
            goTo(Integer.parseInt(functionDecision));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            run();
        }
    }

    private void goTo(int function) {
        if (function == ADD_FUNCTION) {
            addLine();
        }
        if (function == DELETE_FUNCTION) {
            deleteLine();
        }
        if (function == VIEW_FUNCTION) {
            viewLines();
        }
    }

    private void addLine() {
        try {
            String rawLineName = inputView.inputName(InputView.CHOOSE_ADD_LINE);
            Line.validateName(rawLineName);
            Line line = new Line(rawLineName);
            line.add(StationRepository.get(inputView.inputName(InputView.CHOOSE_LINE_BEGINNING)));
            line.add(StationRepository.get(inputView.inputName(InputView.CHOOSE_LINE_ENDING)));
            LineRepository.addLine(line);

            OutputView.printInfo(OutputView.INFO_LINE_ADD);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            addLine();
        }
    }

    private void deleteLine() {
        try {
            String rawLineName = inputView.inputName(InputView.CHOOSE_DELETE_LINE);
            Line.validateName(rawLineName);
            LineRepository.deleteLineByName(rawLineName);

            OutputView.printInfo(OutputView.INFO_LINE_DELETE);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            deleteLine();
        }
    }

    private void viewLines() {
        OutputView.printLines(LineRepository.lines());
    }
}

package subway.controller;

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
            if(Function.isExitDecision(functionDecision, Function.LINE_MENU)) {
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
        String rawLineName = inputView.inputName(InputView.CHOOSE_ADD_LINE);
    }

    private void deleteLine() {
        String rawLineName = inputView.inputName(InputView.CHOOSE_DELETE_LINE);
    }

    private void viewLines() {

    }
}

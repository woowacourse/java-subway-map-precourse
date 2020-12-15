package subway.exception;

import subway.Controller.domain.LineController;
import subway.view.OutputView;

public class MainExceptionHandler {

    private static void goBack() {
        LineController.run();
    }

    private static void printErrorAndGoBack(String error) {
        OutputView.printError(error);
        goBack();
    }

    public static void unselectableMain(String selection, String[] pattern) {
        try {
            ExceptionHandler.unselectable(selection, pattern);
        } catch (CustomException e) {
            printErrorAndGoBack(e.getMessage());
        }
    }
}

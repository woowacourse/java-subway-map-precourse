package subway.Exception;

import subway.Controller.LineController;
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
            ExceptionHandler.isUnSelectable(selection, pattern);
        } catch (CustomException e) {
            printErrorAndGoBack(e.getMessage());
        }
    }
}

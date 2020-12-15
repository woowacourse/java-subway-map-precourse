package subway.controller;

import subway.controller.function.MainFunction;
import subway.controller.message.MainMessage;
import subway.controller.screen.SubwayScreen;
import subway.controller.validation.MainValidator;
import subway.view.SubwayView;

import java.util.Objects;

public class MainController {
    private static boolean isQuit(String functionCode) {
        return Objects.equals(MainFunction.QUIT.getCode(), functionCode);
    }

    public static void run() {
        while (true) {
            SubwayView.displayScreen(SubwayScreen.MAIN);
            SubwayView.notice(MainMessage.SELECT_FUNCTION);
            String functionCode = MainValidator.validateMainFunction(SubwayView.userInput());

            if (isQuit(functionCode)) {
                return;
            }

            MainFunction.callBy(functionCode);
        }
    }

    public static void redirect() {
    }
}

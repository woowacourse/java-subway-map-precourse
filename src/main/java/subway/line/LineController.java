package subway.line;

import subway.view.InputView;

public class LineController {
    private LineController() {
    }

    private static void register() {
        String name = InputView.getLineNameForRegistration();
        String topStation = InputView.getTopStation();
        String bottomStation = InputView.getBottomStation();
        LineService.register(name, topStation, bottomStation);
    }
}

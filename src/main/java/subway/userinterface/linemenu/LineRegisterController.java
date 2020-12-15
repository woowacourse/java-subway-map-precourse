package subway.userinterface.linemenu;

import subway.domain.StationRepository;
import subway.service.LineService;
import subway.userinterface.Menu;
import subway.userinterface.OutputController;
import java.util.Scanner;

public class LineRegisterController implements Menu {
    private static final String LINE_REGISTERED = "\n[INFO] 지하철 노선이 등록되었습니다.";
    private static final String MENU_NAME = "1. 노선 등록";
    private static final String MENU_KEY = "1";
    private static final LineService lineService = new LineService();
    private static final LineRegisterInputController lineRegisterInputController
            = new LineRegisterInputController();
    private static final LineRegisterTopStationInputController topStationInput
            = new LineRegisterTopStationInputController();
    private static final LineRegisterBottomStationController bottomStationInput
            = new LineRegisterBottomStationController();
    private static LineRegisterController lineRegisterController;

    private LineRegisterController() {}

    public static Menu getInstance() {
        if (lineRegisterController == null) {
            lineRegisterController = new LineRegisterController();
        }
        return lineRegisterController;
    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    @Override
    public String getMenuKey() {
        return MENU_KEY;
    }

    @Override
    public void run(Scanner scanner) throws IllegalArgumentException {
        lineService.registerLine(lineRegisterInputController.getUserInput(scanner),
                StationRepository.findStationByName(topStationInput.getUserInput(scanner)),
                StationRepository.findStationByName(bottomStationInput.getUserInput(scanner)));

        OutputController.printInfo(LINE_REGISTERED);
    }
}

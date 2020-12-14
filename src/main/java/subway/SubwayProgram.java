package subway;

import subway.controller.Controller;
import subway.controller.LineController;
import subway.controller.SectionController;
import subway.controller.StationController;
import subway.domain.menu.MainMenuType;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayProgram {
    private static final String STATION = "역";
    private static final String LINE = "노선";
    private static final String SECTION = "구간";

    private final Scanner scanner;
    private final Controller stationController;
    private final Controller lineController;
    private final Controller sectionController;

    public SubwayProgram(Scanner scanner) {
        this.scanner = scanner;
        stationController = new StationController(scanner);
        lineController = new LineController(scanner);
        sectionController = new SectionController(scanner);
    }

    public void run() {
        MainMenuType mainMenuType;
        do {
            mainMenuType = InputView.inputMainMenuType(scanner);
            selectManageMenu(mainMenuType);
            if (MainMenuType.PRINT_MAP.equals(mainMenuType)) {
                OutputView.printSubwayMap();
            }
        } while (!mainMenuType.equals(MainMenuType.END_PROGRAM));
    }

    private void selectManageMenu(MainMenuType mainMenuType) {
        if (MainMenuType.STATION_MANAGE.equals(mainMenuType)) {
            stationController.runMenu(mainMenuType, STATION);
            return;
        }
        if (MainMenuType.LINE_MANAGE.equals(mainMenuType)) {
            lineController.runMenu(mainMenuType, LINE);
            return;
        }
        if (MainMenuType.SECTION_MANAGE.equals(mainMenuType)) {
            sectionController.runMenu(mainMenuType, SECTION);
        }
    }
}

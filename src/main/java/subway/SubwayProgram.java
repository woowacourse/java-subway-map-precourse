package subway;

import subway.controller.LineController;
import subway.controller.SectionController;
import subway.controller.StationController;
import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.domain.line.LineRepository;
import subway.domain.menu.MainMenuType;
import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SubwayProgram {
    private static final String STATION = "역";
    private static final String LINE = "노선";
    private static final String SECTION = "구간";

    private final Scanner scanner;
    private StationController stationController;
    private LineController lineController;
    private SectionController sectionController;

    public SubwayProgram(Scanner scanner) {
        this.scanner = scanner;
        stationController = new StationController(scanner);
        lineController = new LineController(scanner);
        sectionController = new SectionController(scanner);
    }

    public void runMainMenu() {
        MainMenuType mainMenuType;
        do {
            mainMenuType = InputView.inputMainMenu(scanner);
            selectManageMenu(mainMenuType);
            if (MainMenuType.PRINT_MAP.equals(mainMenuType)) {
                OutputView.printSubwayMap();
            }
        }while (!mainMenuType.equals(MainMenuType.END_PROGRAM));
    }

    private void selectManageMenu(MainMenuType mainMenuType) {
        if (MainMenuType.STATION_MANAGE.equals(mainMenuType)) {
            stationController.runStationMenu(mainMenuType, STATION);
            return;
        }
        if (MainMenuType.LINE_MANAGE.equals(mainMenuType)) {
            lineController.runLineMenu(mainMenuType, LINE);
            return;
        }
        if (MainMenuType.SECTION_MANAGE.equals(mainMenuType)) {
            sectionController.runSectionMenu(mainMenuType, SECTION);
        }
    }


}

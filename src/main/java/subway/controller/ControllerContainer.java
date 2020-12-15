package subway.controller;

import subway.controller.line.LineManagementController;
import subway.controller.main.MainMenuController;
import subway.controller.section.SectionManagementController;
import subway.controller.station.StationManagementController;
import subway.domain.station.Station;
import subway.repository.line.LineRepository;
import subway.repository.line.LineRepositoryImpl;
import subway.repository.station.StationRepository;
import subway.repository.station.StationRepositoryImpl;

public class ControllerContainer {

    private static LineRepository lineRepository = new LineRepositoryImpl();
    private static StationRepository stationRepository = new StationRepositoryImpl();

    private static MainMenuController mainMenuController =
            new MainMenuController(stationRepository, lineRepository);
    private static LineManagementController lineManagementController =
            new LineManagementController(stationRepository, lineRepository);
    private static StationManagementController stationManagementController =
            new StationManagementController(stationRepository, lineRepository);
    private static SectionManagementController sectionManagementController =
            new SectionManagementController(stationRepository, lineRepository);

    public static MainMenuController getMainMenuController() {
        return mainMenuController;
    }

    public static LineManagementController getLineManagementController() {
        return lineManagementController;
    }

    public static StationManagementController getStationManagementController() {
        return stationManagementController;
    }

    public static SectionManagementController getSectionManagementController() {
        return sectionManagementController;
    }

    public static LineRepository getLineRepository() {
        return lineRepository;
    }

    public static StationRepository getStationRepository() {
        return stationRepository;
    }
}

package subway.manager;

import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.menu.MainMenu;
import subway.view.InputView;

public class StationManager {
    MainMenu mainMenu;

    public StationManager(Scanner scanner) {
        mainMenu = new MainMenu(new InputView(scanner));
    }

    private void init() {
        Init.INIT_LIST.stream().forEach(name -> StationRepository.addStation(new Station(name)));
        Init.LINE_MAP.keySet().stream().forEach(lines -> {
            Line line = new Line(lines);
            Init.LINE_MAP.get(lines).stream().forEach(name -> {
                line.addStation(new Station(name));
            });
            LineRepository.addLine(line);
        });
    }

    public void start() {
        init();
        mainMenu.runMainMenu();
    }
}

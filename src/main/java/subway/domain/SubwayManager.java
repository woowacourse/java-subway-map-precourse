package subway.domain;

import java.util.Scanner;
import subway.console.MainScreen;

public class SubwayManager {
    private static LineRepository lineRepository;
    private static StationRepository stationRepository;
    private static MainScreen mainScreen;
    private static String mainInput;

    public SubwayManager() {
        lineRepository = new LineRepository();
        stationRepository = new StationRepository();
        mainScreen = new MainScreen();
    }

    public void execute(Scanner scanner) {
        do {
            mainScreen.startProcess(scanner);
        } while(!mainScreen.requestQuitMainScreen());
    }
}

package subway;

import subway.domain.*;

import java.util.Scanner;

public class SubwayProgram {
    private final Scanner scanner;
    private StationRepository newStationRepository;
    private LineRepository newLineRepository;

    public SubwayProgram(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        MainMenu mainMenu = new MainMenu(scanner);
        do {
            int mainMenuNumber = mainMenu.run();
            newStationRepository = new StationRepository();
            selectMainMenu(mainMenuNumber);

            System.out.println(newStationRepository);
        } while (mainMenu.doNext());

    }

    public void selectMainMenu(int mainMenuNumber) {
        if (mainMenuNumber == 1) {
            StationManage newStationManage = new StationManage(scanner);
            newStationManage.manageStation();
        }
    }



}

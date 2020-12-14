package subway;

import subway.domain.*;

import java.util.Scanner;

public class SubwayProgram {
    private final Scanner scanner;
//    private StationRepository newStationRepository;
//    private LineRepository newLineRepository;
    private LineManager newLineManager;

    public SubwayProgram(Scanner scanner) {
        this.scanner = scanner;
        newLineManager = new LineManager(scanner);
        newLineManager.initializeLine();

    }

    public void run() {
        MainMenu mainMenu = new MainMenu(scanner);
        do {
            String mainMenuNumber = mainMenu.run();
            selectMainMenu(mainMenuNumber);
        } while (mainMenu.doNext());
    }

    public void selectMainMenu(String mainMenuNumber) {
        if (mainMenuNumber.equals("1")) {
            StationManager newStationManager = new StationManager(scanner);
            newStationManager.run();
        } else if (mainMenuNumber.equals("2")) {
            newLineManager.run();
        } else if (mainMenuNumber.equals("3")) {
            SectionManager newSectionManager = new SectionManager(scanner);
            newSectionManager.run();
        } else if (mainMenuNumber.equals("4")) {
            for (Line line : LineRepository.lines()) {
                System.out.println(line);
            }
        }
    }
}

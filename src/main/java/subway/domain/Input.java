package subway.domain;

import subway.view.LineController;
import subway.view.SectionController;
import subway.view.StationController;

import java.util.Scanner;

public class Input {
    Scanner scanner;
    private StationController stationController;
    private LineController lineController;
    private SectionController sectionController;
    public static Boolean quit = false;

    public Input(Scanner scanner) {
        this.scanner = scanner;
        stationController = new StationController(scanner);
        lineController = new LineController(scanner);
        sectionController = new SectionController(scanner);
    }

    public void mainInput() {
        System.out.print(String.join("\n", Constant.MAIN_ANNOUNCEMENT, Constant.INPUT_ANNOUNCEMENT));
        String flag = scanner.next();
        if (flag.equals(Constant.FIRST_COMMAND)) {
            stationController.printSelection();
            return;
        }
        if (flag.equals(Constant.SECOND_COMMAND)) {
            lineController.printSelection();
            return;
        }
        if (flag.equals(Constant.THIRD_COMMAND)) {
            sectionController.printSelection();
            return;
        }
        if (flag.equals(Constant.FORTH_COMMAND)) {
            sectionController.readSections();
            return;
        }
        if (flag.equals(Constant.QUIT_COMMAND)) {
            quit = true;
            return;
        }
        System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.INPUT_ERROR_ANNOUNCEMENT));
    }
}

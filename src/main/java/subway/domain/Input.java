package subway.domain;

import subway.Constant;

import java.awt.print.Book;
import java.util.Scanner;

public class Input {
    Scanner scanner;
    StationController stationController;
    LineController lineController;
    SectionController sectionController;
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
        } else if (flag.equals(Constant.SECOND_COMMAND)) {
            lineController.printSelection();
            return;
        } else if (flag.equals(Constant.THIRD_COMMAND)) {

        } else if(flag.equals(Constant.FORTH_COMMAND)){

        } else if (flag.equals(Constant.QUIT_COMMAND)) {
            quit = true;
        }
    }
}

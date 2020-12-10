package subway;

import java.util.Scanner;

public class SubwayProgram {
    private final Scanner scanner;

    public SubwayProgram(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        MainMenu mainMenu = new MainMenu(scanner);
        int mainMenuNumber = mainMenu.inputAndNext();

    }


}

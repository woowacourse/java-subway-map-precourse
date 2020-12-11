package subway;

import java.util.Scanner;

public class SubwayMapProgram {
    public void start(Scanner scanner) {
        String mainInput = "";
        while (true) {
            PrintMainScreen.printMainScreen();
            mainInput = scanner.nextLine();
            if (mainInput.equals("Q")) {
                break;
            }
            MainInputResolver.handleMainInput(mainInput);
        }
    }
}

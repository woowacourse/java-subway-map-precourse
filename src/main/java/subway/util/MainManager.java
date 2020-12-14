package subway.util;

import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class MainManager {
    public void appMain(Scanner scanner) {
        String inputString;
        Constants.printMain();
        while(true) {
            try{
                inputString = scanner.nextLine().trim();
                ErrorManager.checkInput(inputString);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        main(inputString, scanner);
    }

    public void main(String input, Scanner scanner) {
        while(true) {
            if (input.equals("Q")) {
                System.exit(0);
            } else if (input.equals("1")) {
                StationManager.stationMain(scanner);
            } else if (input.equals("2")) {
                LineManager.lineMain(scanner);
            } else if (input.equals("3")) {
                SectionManager.SectionMain(scanner);
            } else if (input.equals("4")) {

            }
        }
    }
}

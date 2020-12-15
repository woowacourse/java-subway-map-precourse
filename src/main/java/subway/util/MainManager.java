package subway.util;

import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class MainManager {
    StationManager stationManager = new StationManager();
    LineManager lineManager = new LineManager();
    SectionManager sectionManager = new SectionManager();

    public void appMain(Scanner scanner) {
        String inputString;
        while(true) {
            while(true) {
                try{
                    Constants.printMain();
                    inputString = scanner.nextLine().trim();
                    ErrorManager.checkInput(inputString);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            main(inputString, scanner);
        }
    }

    public void main(String input, Scanner scanner) {
            if (input.equals("Q")) {
                System.exit(0);
            } else if (input.equals("1")) {
                stationManager.stationMain(scanner);
            } else if (input.equals("2")) {
                lineManager.lineMain(scanner);
            } else if (input.equals("3")) {
                sectionManager.SectionMain(scanner);
            } else if (input.equals("4")) {

            }
    }
}

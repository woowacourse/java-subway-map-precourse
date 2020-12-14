package subway.util;

import java.util.Scanner;

public class AppManager {
    public void appMain(Scanner scanner) {
        Constants.printMain();
        String inputString = scanner.nextLine().trim();
        // 에러 처리
        while(true) {
            if (inputString.equals("Q")) {
                System.exit(0);
            } else if (inputString.equals("1")) {

            } else if (inputString.equals("2")) {

            } else if (inputString.equals("3")) {

            } else if (inputString.equals("4")) {

            }
        }
    }

    public void stationMain(Scanner scanner) {
        Constants.printStation();
        String inputString = scanner.nextLine().trim();
        if(inputString.equals("B")) {
            return;
        } else if(inputString.equals("1")) {

        } else if(inputString.equals("2")) {

        } else if(inputString.equals("3")) {

        }
        return;
    }

    public void LineMain(Scanner scanner) {
        Constants.printLine();
        String inputString = scanner.nextLine().trim();
        if(inputString.equals("B")) {
            return;
        } else if(inputString.equals("1")) {

        } else if(inputString.equals("2")) {

        } else if(inputString.equals("3")) {

        }
        return;
    }

    public void SectionMain(Scanner scanner) {
        Constants.printSection();
        String inputString = scanner.nextLine().trim();
        if(inputString.equals("B")) {
            return;
        } else if(inputString.equals("1")) {

        } else if(inputString.equals("2")) {

        }
        return;
    }

}

package subway;

import subway.views.SystemOutput;
import subway.views.UserInput;

import java.util.Scanner;

public class SubwayManager {
    UserInput userInput;

    public SubwayManager(Scanner scanner) {
        this.runManager(scanner);
    }

    public void runManager(Scanner scanner) {
        this.userInput = new UserInput(scanner);
        SystemOutput.printMainMessage();
        userInput.getMainInput();
    }

    public void stationManager() {

    }
}

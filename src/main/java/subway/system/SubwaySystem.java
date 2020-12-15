package subway.system;

import java.util.Scanner;
import subway.manager.SubwayManager;
import subway.validator.SubwayManagerValidator;
import subway.view.SubwayManagerView;

public class SubwaySystem {

    static final int OPTION_ONE = 1;
    static final int OPTION_TWO = 2;
    static final int OPTION_THREE = 3;
    static final int OPTION_FOUR = 4;
    static final String WANT_QUIT_CODE = "Q";
    static final String ASK_OPTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    static final String ERROR_PREFIX = "[ERROR] ";

    String userOption = "";
    SubwayManager subwayManager;
    StationSystem stationSystem;
    LineSystem lineSystem;
    SectionSystem sectionSystem;

    public SubwaySystem() {
        this.subwayManager =  new SubwayManager();
        this.stationSystem = new StationSystem();
        this.lineSystem = new LineSystem();
        this.sectionSystem = new SectionSystem();
    }

    public void run(Scanner scanner) {
        while (!userOption.equals(WANT_QUIT_CODE)) {
            SubwayManagerView.printSubwayManagerMainScreen();
            userOption = getUserOption(scanner);
            runOptionMenu(userOption, scanner);
        }
    }

    public String getUserOption(Scanner scanner) {
        try {
            System.out.println(ASK_OPTION_MESSAGE);
            String userOption = scanner.nextLine();
            System.out.println();
            SubwayManagerValidator.validateUserOption(userOption);
            return userOption;
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return getUserOption(scanner);
        }
    }

    public void runOptionMenu(String userOption, Scanner scanner) {
        if (!Character.isDigit(userOption.charAt(0))) {
            return;
        }
        int optionNumber = Integer.parseInt(userOption);
        if (optionNumber == OPTION_ONE) {
            stationSystem.run(scanner);
        }
        if (optionNumber == OPTION_TWO) {
            lineSystem.run(scanner);
        }
        if (optionNumber == OPTION_THREE) {
            sectionSystem.run(scanner);
        }
        if (optionNumber == OPTION_FOUR) {
            subwayManager.printMap();
        }
    }
}

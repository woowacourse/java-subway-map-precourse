package subway;

import java.util.Scanner;
import controller.LineManageController;
import controller.MainController;
import controller.SectionManageController;
import controller.StationManageController;
import utils.ValidateUtils;
import view.LineManageView;
import view.MainView;
import view.SectionManageView;
import view.StationManageView;

public class SubwayManager {
    public static final int INPUT_MANAGE_STATION = 1;
    public static final int INPUT_MANAGE_LINE = 2;
    public static final int INPUT_MANAGE_SECTION = 3;
    public static final int INPUT_PRINT_LINES = 4;
    public static final String INPUT_QUIT = "Q";

    public static final String ERROR_INVALID_INPUT = "\n[ERROR] 유효하지 않은 입력입니다.\n";

    private MainView mainView;
    private StationManageView stationManageView;
    private LineManageView lineManageView;
    private SectionManageView sectionManageView;
    private Scanner scanner;

    public SubwayManager(Scanner scanner) {
        this.scanner = scanner;
        initMainView();
        initStationManageView();
        initLineManageView();
        initSectionManageView();
    }

    private void initMainView() {
        mainView = new MainView(scanner);
        MainController mainCotroller = new MainController(mainView);
        mainView.setController(mainCotroller);
    }

    private void initStationManageView() {
        stationManageView = new StationManageView(scanner);
        StationManageController stationManagerController =
                new StationManageController(stationManageView);
        stationManageView.setController(stationManagerController);
    }

    private void initLineManageView() {
        lineManageView = new LineManageView(scanner);
        LineManageController lineManageController = new LineManageController(lineManageView);
        lineManageView.setController(lineManageController);
    }

    private void initSectionManageView() {
        sectionManageView = new SectionManageView(scanner);
        SectionManageController sectionManageController =
                new SectionManageController(sectionManageView);
        sectionManageView.setController(sectionManageController);
    }

    public void run() {
        while (true) {
            mainView.run();
            String input = mainView.input();
            while (!ValidateUtils.validateMainInput(input)) {
                mainView.printMessage(ERROR_INVALID_INPUT);
                mainView.printInputMessage();
                input = mainView.input();
            }
            if (input.equals(INPUT_QUIT)) {
                break;
            }
            processInput(Integer.valueOf(input));
        }
    }

    private void processInput(int input) {
        if (input == INPUT_MANAGE_STATION) {
            stationManageView.run();
        }
        if (input == INPUT_MANAGE_LINE) {
            lineManageView.run();
        }
        if (input == INPUT_MANAGE_SECTION) {
            sectionManageView.run();
        }
        if (input == INPUT_PRINT_LINES) {
            mainView.showLines();
        }
    }
}

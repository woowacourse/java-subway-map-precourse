package subway;

import subway.service.input.InputService;
import subway.service.input.ScannerInputService;
import subway.service.output.OutputService;
import subway.service.output.StringBuilderOutputService;

import java.util.Scanner;

public class StationManageApp {
    private final InputService inputService;
    private final OutputService outputService;

    public StationManageApp() {
        inputService = ScannerInputService.of(new Scanner(System.in));
        outputService = StringBuilderOutputService.of(new StringBuilder());
    }

    public static StationManageApp of() {
        return new StationManageApp();
    }

    public void startManage() {
        while (true) {
            outputService.printMain();
            int option = inputService.getMainOption();
            if (isQuit(option)) {
                break;
            }
            chooseOption(option);
        }
    }

    private boolean isQuit(int option) {
        if (option == InputService.OPTION_QUIT) {
            return true;
        }
        return false;
    }

    private void chooseOption(int mainOption) {
        if (mainOption == InputService.MANAGE_STATION) {
            manageStation();
        }
        if (mainOption == InputService.MANAGE_ROUTE) {
            manageRoute();
        }
        if (mainOption == InputService.MANAGE_SECTION) {
            mangeSection();
        }
        if (mainOption == InputService.MANAGE_MAP) {
            manageMap();
        }
    }

    private void manageMap() {
    }

    private void mangeSection() {
        outputService.printManageSection();
    }

    private void manageRoute() {
        outputService.printManageRoute();
    }

    private void manageStation() {
        outputService.printSManageStation();
        int manageStationOption = inputService.getManageStationOption();
        System.out.println("manageStationOption = " + manageStationOption);
    }
}

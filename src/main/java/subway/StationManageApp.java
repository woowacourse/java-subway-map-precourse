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
            chooseOption(inputService.getMainOption());
        }
    }

    private void chooseOption(int mainOption) {
        if (mainOption == 1) {
            stationManage();
        }
        if (mainOption == 2) {

        }
        if (mainOption == 3) {

        }
        if (mainOption == 4) {

        }
    }

    private void stationManage() {
        outputService.printStationManage();
    }
}

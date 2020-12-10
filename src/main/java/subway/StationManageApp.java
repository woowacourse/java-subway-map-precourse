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
        outputService.printMain();
    }
}

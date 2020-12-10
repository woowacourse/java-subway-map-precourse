package subway;

import subway.service.input.InputService;
import subway.service.input.ScannerInputService;

import java.util.Scanner;

public class StationManageApp {
    private static InputService inputService;

    public StationManageApp() {
        inputService = ScannerInputService.of(new Scanner(System.in));
    }

    public static StationManageApp of() {
        return new StationManageApp();
    }

    public void startManage() {

    }
}

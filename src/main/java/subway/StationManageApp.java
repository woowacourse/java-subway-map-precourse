package subway;

import subway.service.InputService;

import java.util.Scanner;

public class StationManageApp {
    private static InputService inputService;

    public StationManageApp(Scanner scanner) {
        inputService = InputService.of(scanner);
    }

    public static StationManageApp of(Scanner scanner) {
        return new StationManageApp(scanner);
    }

    public void startManage() {

    }
}

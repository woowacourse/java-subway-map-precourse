package subway.service;

import subway.constant.Information;

import java.util.Scanner;

public class StationService {

    private Scanner scanner;

    public StationService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println(Information.STATION_INFO);
    }
}

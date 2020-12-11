package subway.service;

import subway.constant.Information;

import java.util.Scanner;

public class AreaService {

    private Scanner scanner;

    public AreaService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println(Information.AREA_INFO);
    }
}

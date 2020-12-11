package subway.service;

import subway.constant.Information;

import java.util.Scanner;

public class LineService {

    private Scanner scanner;

    public LineService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println(Information.LINE_INFO);
    }
}

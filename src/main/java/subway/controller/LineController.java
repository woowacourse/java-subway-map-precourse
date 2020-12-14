package subway.controller;

import subway.service.line.LineService;

import java.util.Scanner;

public class LineController {
    public static void startLine(Scanner scanner) {
        LineService lineService = new LineService();
        lineService.manage(scanner);
    }
}

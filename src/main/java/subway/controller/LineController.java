package subway.controller;

import subway.service.line.LineService;

import java.util.Scanner;

public class LineController {
    public static void startLine(Scanner scanner) {
        LineService.manageLine(scanner);
    }
}

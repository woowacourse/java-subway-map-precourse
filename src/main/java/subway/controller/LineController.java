package subway.controller;

import subway.service.line.LineService;

import java.util.Scanner;

/**
 * LineController.java : 지하철 노선에 대한 컨트롤러 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class LineController {
    public static void startLine(Scanner scanner) {
        LineService lineService = new LineService();
        lineService.manage(scanner);
    }
}

package subway;

import java.util.Scanner;
import subway.controller.MenuController;
import subway.domain.service.LineService;
import subway.domain.service.StationService;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        StationService.init();
        LineService.init();
        MenuController.runProgram(scanner);
    }
}

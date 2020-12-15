package subway.controller;

import java.util.Scanner;

import subway.view.Input;
import subway.view.Output;

public class SubwayController {
    public static Output output;
    
    public SubwayController(Scanner scanner) {
        Input.scanner = scanner;
        output = new Output();
    }
    
    public void run() {
        while(true) {
            output.printMainMenu();
        }
    }
}

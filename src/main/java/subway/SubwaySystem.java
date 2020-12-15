package subway;

import subway.controller.EntireSystem;
import subway.controller.Initiator;

import java.util.Scanner;

public class SubwaySystem {
    private final Scanner scanner;

    SubwaySystem(Scanner scanner) {
        Initiator.intiate();
        this.scanner = scanner;
    }

    public void process() {
        EntireSystem entireSystem = new EntireSystem(scanner);
        entireSystem.runProgram();
    }
}

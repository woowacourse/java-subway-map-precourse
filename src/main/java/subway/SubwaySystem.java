package subway;

import subway.controller.Initiator;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.Scanner;

public class SubwaySystem {
    private final Scanner scanner;

    SubwaySystem(Scanner scanner) {
        Initiator.intiate();
        this.scanner = scanner;
    }

    public void process() {

    }
}

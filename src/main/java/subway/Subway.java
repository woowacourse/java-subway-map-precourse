package subway;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.Scanner;

public class Subway {
    private Scanner scanner;

    public Subway(Scanner scanner) {
        this.scanner = scanner;
        StationRepository.init();
        LineRepository.init();
    }

}

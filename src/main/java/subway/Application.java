package subway;

import subway.controller.Controller;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        init();
        new Controller(scanner);
    }

    public static void init() {
        StationRepository.init();
        LineRepository.init();

    }
}

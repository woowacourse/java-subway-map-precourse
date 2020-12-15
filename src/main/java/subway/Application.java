package subway;

import java.util.Scanner;
import subway.domain.SubwaySystem;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwaySystem subwaySystem = new SubwaySystem(scanner);
        subwaySystem.run();
        scanner.close();
    }
}

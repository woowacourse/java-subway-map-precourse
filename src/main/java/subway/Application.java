package subway;

import java.util.Scanner;
import subway.controller.TotalDirector;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        TotalDirector totalAdminister = new TotalDirector();
        totalAdminister.run();
    }
}

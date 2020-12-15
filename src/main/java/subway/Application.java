package subway;

import java.util.Scanner;
import subway.administer.TotalAdminister;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        TotalAdminister totalAdminister = new TotalAdminister();
        totalAdminister.run();
    }
}

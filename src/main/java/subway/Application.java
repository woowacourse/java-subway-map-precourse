package subway;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        Controller controller = new Controller(scanner);
        controller.run();
    }
}

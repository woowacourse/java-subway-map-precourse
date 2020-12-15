package subway;

import java.util.Scanner;
import subway.controller.Controller;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller(scanner);
        
        controller.run();
    }
}

package subway;

import subway.service.MainService;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MainService mainService = new MainService(scanner);
        mainService.run();
    }
}

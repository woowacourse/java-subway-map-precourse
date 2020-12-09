package subway;

import subway.control.MainControlCenter;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        MainControlCenter seoulMetro = new MainControlCenter();
        seoulMetro.startMainControl(scanner);
    }
}

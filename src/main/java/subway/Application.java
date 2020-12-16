package subway;
/*
 * Application
 *
 * version 1.0
 *
 * 2020.12.15
 *
 * Copyright (c) by Davinci.J
 */
import subway.controller.Subway;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView.insertScanner(scanner);
        Subway.run();
    }
}

package subway.view;

import java.util.Scanner;

import subway.screen.Screen;

public class Input {
    public static Scanner scanner;
	
    public static String chooseFunction() {
        Screen.chooseFunction();
        return scanner.next();
    }
}

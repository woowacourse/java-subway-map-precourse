package subway.view.component.common;

import java.util.Scanner;

public class InputViewComponent {
    final static Scanner scanner = new Scanner(System.in);

    public static String getInput(){
        return scanner.nextLine();
    }
}

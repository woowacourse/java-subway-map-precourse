package input;

import java.util.Scanner;

public class Input {
    final Scanner scanner;
    public Input(Scanner scanner){
        this.scanner = scanner;
    }

    public String inputFunction(){
        return scanner.next();
    }

    public String inputStationName(){
        return scanner.next();
    }
}

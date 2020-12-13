package input;

import exception.NameLengthException;

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
        String answer = scanner.next();
        if(answer.length() < 3){
            throw new NameLengthException();
        }
        return answer;
    }

    public String inputLineName(){
        return scanner.next();
    }

    public String inputOrder(){
        return scanner.next();
    }
}

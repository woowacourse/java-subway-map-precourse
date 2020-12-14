package subway.domain;

import java.util.Scanner;

public class User {

    final Scanner scanner = new Scanner(System.in);

    public String getInput(){
        return scanner.nextLine();
    }
}

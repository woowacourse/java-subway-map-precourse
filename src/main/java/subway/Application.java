package subway;

import subway.domain.Input;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Input input = new Input(scanner);
        while(!input.quit){
            input.mainInput();
        }
    }

    void initialSetting() {

    }
}

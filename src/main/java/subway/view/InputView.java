package subway.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    final static Scanner scanner = new Scanner(System.in);

    public static String nextLine() {
        return scanner.nextLine();
    }

    public static int nextInt(){
        try {
            return scanner.nextInt();
        }catch (InputMismatchException e){
            throw new InputMismatchException("[ERROR] 숫자가 아닌 값은 입력할 수 없습니다.");
        }
    }
}

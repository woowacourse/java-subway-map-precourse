package subway.view;

import java.util.Scanner;

public class InputView {
    private InputView(){

    }

    /**
     * 데이터 입력 기본 포맷
     */
    public static String scanData(Scanner scanner){

        return scanner.nextLine();
    }
}

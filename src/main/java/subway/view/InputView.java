package subway.view;


import static subway.view.InputView.InputMessage.MAIN_OPTION;

import java.util.Scanner;
import subway.domain.MainOption;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public MainOption readMainOption() {
        System.out.println(MAIN_OPTION.getMessage());
        return MainOption.of(scanner.nextLine());
    }

    protected enum InputMessage {
        MAIN_OPTION("## 메인 화면\n"
                + "1. 역 관리\n"
                + "2. 노선 관리\n"
                + "3. 구간 관리\n"
                + "4. 지하철 노선도 출력\n"
                + "Q. 종료\n"),
        ;

        private final String message;

        InputMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}

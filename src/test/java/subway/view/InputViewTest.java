package subway.view;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import subway.exception.NoInitialScannerException;

import java.util.Scanner;

class InputViewTest {

    @Test
    @Description("InputView Scanner 안넣고 호출시 예외 발생")
    public void noScannerExceptionTest() {
        Assertions.assertThrows(NoInitialScannerException.class, () -> {
            InputView.getInstance();
        });
    }

    @Test
    @Description("InputView 싱글톤 테스트")
    public void inputViewSigleTonTest() {
        Scanner sc = new Scanner(System.in);
        InputView.initInputView(sc);

        InputView instance1 = InputView.getInstance();
        InputView instance2 = InputView.getInstance();

        Assertions.assertSame(instance1, instance2);
    }

}
package input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class InputTest {
    Scanner scanner = new Scanner(System.in);

    @Test
    @DisplayName("역 이름이 3글자 미만일 때 예외 발생")
    public void inputStationName() {
        Input input = new Input(scanner);
        input.inputStationName();
    }

    @Test
    void inputLineName() {
    }
}
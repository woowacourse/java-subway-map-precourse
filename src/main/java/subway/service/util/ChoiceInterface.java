package subway.service.util;

import java.util.Scanner;

/**
 * ChoiceInterface.java : 지하철 역, 지하철 노선 기능 선택에 대한 인터페이스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public interface ChoiceInterface {
    boolean choose(String input, Scanner scanner);
}

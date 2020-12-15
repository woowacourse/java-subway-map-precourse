package subway.service.util;

import java.util.Scanner;

/**
 * FeatureInterface.java : 지하철 역, 지하철 노선 기능에 대한 인터페이스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public interface FeatureInterface {
    boolean add(Scanner scanner);
    boolean delete(Scanner scanner);
    boolean show();
}

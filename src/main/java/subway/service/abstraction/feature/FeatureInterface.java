package subway.service.abstraction.feature;

import java.util.Scanner;

public interface FeatureInterface {
    boolean chooseFeature(String input, Scanner scanner);
    boolean add(Scanner scanner);
    boolean delete(Scanner scanner);
    boolean show();
}

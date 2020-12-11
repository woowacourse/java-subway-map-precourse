package subway.service;

import java.util.Scanner;

public interface FeatureInterface {
    boolean isInput(String input);
    void chooseFeature(String input);
    void chooseSubwayFeature(String input, Scanner scanner);
}

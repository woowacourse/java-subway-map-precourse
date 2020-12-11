package subway.service;

import java.util.Scanner;

public interface FeatureInterface {
    boolean isInput(String input);
    void chooseSubwayFeature(String input, Scanner scanner);
    void chooseFeature(String input);
}

package subway.controller;

import java.util.Scanner;

public interface Controller {
    void mappingCommandToValidFunction(int command, Scanner scanner);
}

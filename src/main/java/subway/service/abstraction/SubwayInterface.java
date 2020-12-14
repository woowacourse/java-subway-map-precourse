package subway.service.abstraction;

import java.util.Scanner;

public interface SubwayInterface {
    void manage(Scanner scanner);
    boolean check(String input);
    boolean choose(String input, Scanner scanner);
}

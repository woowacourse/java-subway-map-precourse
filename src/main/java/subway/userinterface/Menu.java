package subway.userinterface;

import java.util.Scanner;

public interface Menu {
    String getMenuName();
    String getMenuKey();
    void run(Scanner scanner);
}

package subway.menu;

import java.util.Scanner;

public interface MenuModel {
    public String getSelection();

    public String getFeature();

    public void moveView(Scanner scanner);
}

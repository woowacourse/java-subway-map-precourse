package subway.menu;

import java.util.Scanner;
import java.util.function.Consumer;

public interface MenuModel {
    public String getSelection();

    public String getFeature();

    public Consumer<Scanner> getMove();

}

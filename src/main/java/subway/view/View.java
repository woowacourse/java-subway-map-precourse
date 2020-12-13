package subway.view;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class View {

    public static final String KEY_BACK = "B";
    public static final String KEY_QUIT = "Q";
    Map<String, String> menu;
    protected Scanner scanner;

    public abstract void startView();

    public View(Scanner scanner) {
        menu = new LinkedHashMap<>();
        this.scanner = scanner;
    }

    protected void printMenu() {
        for (String key : menu.keySet()) {
            System.out.println(key + ". " + menu.get(key));
        }
    }

    protected boolean hasKey(String selection) {
        if (menu.containsKey(selection)) {
            return true;
        }
        return false;
    }
}

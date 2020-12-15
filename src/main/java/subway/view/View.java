package subway.view;

import static subway.resource.TextResource.*;

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
        System.out.println(ASK_FUNCTION);
    }

    protected void checkKey(String selection) {
        if (!menu.containsKey(selection)) {
            throw new IllegalArgumentException(ERROR_INVALID_FUNCTION);
        }
    }
}

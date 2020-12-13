package subway;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private String title;
    private List<String> itemList;

    public Menu(String title, List<String> itemList) {
        this.title = title;
        this.itemList = itemList;
    }

    public String load(Scanner scanner) {
        Print.menu(this.title, this.itemList);
        System.out.println();
        Print.hashMessage(Constant.CHOOSE_FUNCTION);
        String input = scanner.next();
        System.out.println();
        return Exception.checkMenu(input, this.itemList);
    }
}

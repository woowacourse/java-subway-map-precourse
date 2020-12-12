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
        printMenu();
        printInputMessage();
        String input = scanner.next();
        return Exception.checkMenu(input, this.itemList);
    }

    public void printMenu() {
        System.out.println(Constant.HEAD_HASH + this.title);
        for (int i = 0; i < this.itemList.size(); i++) {
            System.out.println(this.itemList.get(i));
        }
    }

    public void printInputMessage() {
        System.out.println();
        System.out.println(Constant.CHOOSE_FUNCTION);
    }
}

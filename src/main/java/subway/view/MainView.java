package subway.view;

import java.util.Scanner;

public class MainView extends SelectionView{

    private static final String VIEW_NAME = "메인";

    public MainView(Scanner scanner) {
        AbstractView.scanner = scanner;
        this.goBackText = EXIT_TEXT;
    }

    @Override
    protected void initViewName() {
        this.name = VIEW_NAME;
    }

    @Override
    public void setVisible() {
        while (true) {
            printMenu();
            int input = inputMenuOption();
            if (input == GO_BACK_CODE) {
                break;
            }
            visitView(input);
        }
    }
}

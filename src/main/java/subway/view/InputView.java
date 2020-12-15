package subway.view;

import java.util.Scanner;
import subway.domain.selector.Selector;
import subway.domain.selector.menu.Menu;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final InputValidator inputValidator = new InputValidator();
    private static final MessageView messageView = new MessageView();
    private static final OutputView outputView = new OutputView();

    public Selector getSelector(Menu menu) {
        try {
            messageView.printSelectSelectorMessage();
            String input = scanner.nextLine();
            inputValidator.validateSelectorId(menu, input);
            if (menu.getMenus().get(input) != null) {
                return menu.getMenus().get(input);
            }
            return menu.getItems().get(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            outputView.printScreen(menu);
            return getSelector(menu);
        }
    }

    public String getName() {
        try {
            String name = scanner.nextLine();
            inputValidator.validateContainSpecialCharacters(name);
            return name;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return getName();
        }
    }

    public int getNumber() {
        return Integer.parseInt(scanner.nextLine());
    }

}

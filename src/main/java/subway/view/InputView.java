package subway.view;

import java.util.Scanner;
import subway.domain.selector.Selector;
import subway.domain.selector.menu.Menu;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final InputValidator inputValidator = new InputValidator();
    private static final MessageView messageView = new MessageView();

    public Selector getSelector(Menu menu) {
        try {
            messageView.printSelectSelectorMessage();
            String input = scanner.nextLine();
            inputValidator.validateSelectorNumber(menu, input);
            if (menu.getMenus().get(input) != null) {
                return menu.getMenus().get(input);
            }
            return menu.getItems().get(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getSelector(menu);
        }
    }

    public String getStationName() {
        return scanner.nextLine();
    }

}

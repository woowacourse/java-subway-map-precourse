package subway.domain.menu.linemenu;

import subway.domain.LineRepository;
import subway.userinterface.MenuInterface;
import subway.userinterface.Error;
import subway.userinterface.Info;

import java.util.Scanner;

public class DeleteLineMenu implements LineManageMenu {
    public static final String MENU_BUTTON = "2";

    @Override
    public void run(Scanner scanner) {
        MenuInterface.printDeleteLine();

        String lineNameInput = scanner.next();
        if (Error.printNotExistLineError(lineNameInput)) {
            return;
        }
        LineRepository.deleteLineByName(lineNameInput);
        Info.printLineDeleted(lineNameInput);
    }
}

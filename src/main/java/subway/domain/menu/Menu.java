package subway.domain.menu;

import java.util.Arrays;
import java.util.function.Function;

import subway.controller.ManagementController;
import subway.exception.SubwayRuntimeException;
import subway.exception.function.NoSuchIdentifierException;
import subway.view.InputView;
import subway.view.OutputView;

public interface Menu {

    String LINE_FEED = "\n";

    String getIdentifier();

    String getName();

    Function<ManagementController, ManagementController> getFunction();

    boolean equalsIdentifier(final String identifier);

    static Menu findMenu(final Menu[] menus) {
        String identifier = InputView.inputFunctionIdentifier();

        Menu selectedMenu;

        try {
            selectedMenu = Arrays.stream(menus)
                    .filter(menu -> menu.equalsIdentifier(identifier))
                    .findAny()
                    .orElseThrow(NoSuchIdentifierException::new);
        } catch (NoSuchIdentifierException e) {
            System.out.println(e.getMessage() + LINE_FEED);
            return findMenu(menus);
        }

        return selectedMenu;
    }

    static ManagementController function(ManagementController managementController,
                                         final String viewTitle,
                                         final Menu[] menus) {
        OutputView.printFunctions(viewTitle, menus);

        try {
            managementController = findMenu(menus)
                    .getFunction()
                    .apply(managementController);
        } catch (SubwayRuntimeException e) {
            System.out.println(e.getMessage() + LINE_FEED);
            return function(managementController, viewTitle, menus);
        }

        return managementController;
    }
}

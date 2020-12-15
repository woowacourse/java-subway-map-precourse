package subway.domain.line;

import java.util.Scanner;
import subway.common.ErrorMessage;
import subway.domain.menu.Menu;
import subway.domain.menu.MenuInputManager;
import subway.domain.SubwayRepository;
import subway.common.ErrorMessageException;
import subway.domain.menu.MenuKeys;
import subway.domain.menu.MenuOutputManager;

public class LineService {
    private final MenuInputManager menuInputManager;
    private final LineInputManager lineInputManager;

    public LineService(Scanner scanner, MenuInputManager menuInputManager) {
        this.menuInputManager = menuInputManager;
        lineInputManager = new LineInputManager(scanner);

    }

    public void run() {
        while (true) {
            MenuOutputManager.printMenu(Menu.LINE);
            String inputKey = menuInputManager.getLineInput();
            if (inputKey.equals(MenuKeys.BACK.getKey())) {
                return;
            }
            runSystemByInput(inputKey);
        }
    }

    private void runSystemByInput(String inputKey) {
        if (inputKey.equals(MenuKeys.ONE.getKey())) {
            addLine();
        }
        if (inputKey.equals(MenuKeys.TWO.getKey())) {
            deleteLine();
        }
        if (inputKey.equals(MenuKeys.THREE.getKey())) {
            lookupLines();
        }
    }

    private void addLine() {
        try {
            String[] lineInfo = lineInputManager.getLineInfoToAdd();
            SubwayRepository.createSubwayRealLine(lineInfo);
            LineOutputManager.printAddedInfo();
        } catch (ErrorMessageException errorMessageException) {
            ErrorMessage.print(errorMessageException);
        }
    }

    private void deleteLine() {
        try {
            String name = lineInputManager.getLineNameToDelete();
            SubwayRepository.deleteSubwayLineByName(name);
            LineOutputManager.printDeletedInfo();
        } catch (ErrorMessageException errorMessageException) {
            ErrorMessage.print(errorMessageException);
        }
    }

    private void lookupLines() {
        LineOutputManager.printLines();
    }

}

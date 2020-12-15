package subway.domain.path;

import java.util.Arrays;
import java.util.Scanner;
import subway.common.ErrorMessage;
import subway.common.ErrorMessageException;
import subway.domain.SubwayRepository;
import subway.domain.menu.Menu;
import subway.domain.menu.MenuInputManager;
import subway.domain.menu.MenuKeys;
import subway.domain.menu.MenuOutputManager;

public class PathService {

    private final MenuInputManager menuInputManager;
    private final PathInputManager pathInputManager;

    public PathService(Scanner scanner, MenuInputManager menuInputManager) {
        this.menuInputManager = menuInputManager;
        pathInputManager = new PathInputManager(scanner);
    }

    public void run() {
        while (true) {
            MenuOutputManager.printMenu(Menu.PATH);
            String inputKey = menuInputManager.getPathInput();
            if (inputKey.equals(MenuKeys.BACK.getKey())) {
                return;
            }
            runSystemByInput(inputKey);
        }
    }

    private void runSystemByInput(String inputKey) {
        if (inputKey.equals(MenuKeys.ONE.getKey())) {
            addPath();
        }
        if (inputKey.equals(MenuKeys.TWO.getKey())) {
            deletePath();
        }
    }

    private void addPath() {
        try {
            String[] pathInfo = pathInputManager.getPathInfoToAdd();
            SubwayRepository.addPathByLineNameAndIndex(pathInfo);
            PathOutputManager.printAddedInfo();
        } catch (ErrorMessageException errorMessageException) {
            ErrorMessage.print(errorMessageException);
        }
    }

    private void deletePath() {
        try {
            String[] pathInfo = pathInputManager.getPathInfoToDelete();
            SubwayRepository.deleteStationOnPathByLineName(pathInfo);
            PathOutputManager.printDeletedInfo();
        } catch (ErrorMessageException errorMessageException) {
            ErrorMessage.print(errorMessageException);
        }
    }

}

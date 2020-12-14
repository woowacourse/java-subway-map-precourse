package subway.domain.path;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.SubwayRepository;
import subway.domain.menu.Menu;
import subway.domain.menu.MenuInputManager;
import subway.common.ErrorMessage;
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
            String input = menuInputManager.getPathInput();
            if (input.equals(MenuKeys.BACK.getKey())) {
                return;
            }
            runSystemByInput(input);
        }
    }

    private void runSystemByInput(String input) {
        if (input.equals(MenuKeys.ONE.getKey())) {
            addPath();
        }
        if (input.equals(MenuKeys.TWO.getKey())) {
            deletePath();
        }
    }

    private void addPath() {
        String[] pathInfo = pathInputManager.getPathInfoToAdd();
        if (Arrays.asList(pathInfo).contains(ErrorMessage.OUT)) {
            return;
        }
        SubwayRepository.addPathByLineName(pathInfo);
        PathOutputManager.printAddedInfo();
    }

    private void deletePath() {
        String[] pathInfo = pathInputManager.getPathInfoToDelete();
        if (Arrays.asList(pathInfo).contains(ErrorMessage.OUT)) {
            return;
        }
        SubwayRepository.deleteStationOnPathByLineName(pathInfo);
        PathOutputManager.printDeletedInfo();
    }

}

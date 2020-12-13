package subway.controller;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.MenuItemsRepository;
import subway.domain.SubwayRepository;
import subway.view.ErrorMessage;
import subway.view.InfoMessage;
import subway.view.Menu;

public class PathSystem {

    private MenuInputManager menuInputManager;
    private PathInputManager pathInputManager;

    public PathSystem(Scanner scanner, MenuInputManager menuInputManager){
        this.menuInputManager = menuInputManager;
        pathInputManager = new PathInputManager(scanner);
    }

    public void run() {
        while (true) {
            Menu.printMenu(MenuItemsRepository.getPathItems());
            String input = menuInputManager.getStationInput();
            if (input.equals("B")) {
                return;
            }
            runSystemByInput(input);
        }
    }

    private void runSystemByInput(String input) {
        if (input.equals("1")) {
            addPath();
        }
        if (input.equals("2")) {
            deletePath();
        }
    }

    private void deletePath() {
        String[] pathInfo = pathInputManager.getPathInfoToDelete();
        if (Arrays.asList(pathInfo).contains(ErrorMessage.OUT)) {
            return;
        }
        SubwayRepository.deleteStationOnPathByLineName(pathInfo);
        InfoMessage.printPathDeleted();
    }

    private void addPath() {
        String[] pathInfo = pathInputManager.getPathInfoToAdd();
        if (Arrays.asList(pathInfo).contains(ErrorMessage.OUT)) {
            return;
        }
        SubwayRepository.addPathByLineName(pathInfo[0],Integer.parseInt(pathInfo[2]),pathInfo[1]);
        InfoMessage.printPathAdded();
    }

}

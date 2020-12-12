package subway.controller;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;
import subway.domain.MenuItemsRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
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
            System.out.println("구간 등록");
        }
        if (input.equals("2")) {
            deletePath();
            System.out.println("구간 삭제");
        }
    }

    private void deletePath() {
    }
    //TODO : 구간등록 기존에 없는 line 입력하면 프로그램이 죽음;;;
    // 역 이름 validcheck 안됨;; 기존 없는 역도 그냥 ㄷ지나감;;
    private void addPath() {
        String[] pathInfo = pathInputManager.getPathToAdd();
        if (Arrays.asList(pathInfo).contains(ErrorMessage.OUT)) {
            return;
        }
        SubwayRepository.addPathByLineName(pathInfo[0],Integer.parseInt(pathInfo[2]),pathInfo[1]);
        InfoMessage.printPathAdded();

    }


}

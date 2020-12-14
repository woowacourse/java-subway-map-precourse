package subway.domain;

import subway.SubwaySystem;
import subway.utils.Validator;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainMenu {
    public enum MainEnums {
        STATION_MANAGE() {
            @Override
            public void MainMenuControl() {
                //stationMenu();
            }
        };

        public abstract void MainMenuControl();
    }

    private static boolean isMainMenuRun = true;

    public static boolean getIsMainMenuRun(){
        return isMainMenuRun;
    }

    public static void mainMenuRun() {
        try {
            OutputView.mainView();
            mainMenuInput();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println("[ERROR] " + e.getMessage());
            System.out.println();
        }
    }

    private static void mainMenuInput() throws IllegalArgumentException {
        String inputMsg = InputView.getInput();
        if (!Validator.isValidMainMenuInput(inputMsg)) {
            throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
        }
        mainMenuController(inputMsg);
    }

    private static void mainMenuController(String inputMsg) {
        List<String> mainOrders = new ArrayList<>(Arrays.asList("STATION_MANAGE"));
        if (inputMsg.equals("Q")) {
            mainStop();
            return;
        }
        int mainSelectNumber = Integer.parseInt(inputMsg);
        MainEnums mainEnums = MainEnums.valueOf(mainOrders.get(mainSelectNumber - 1));
        mainEnums.MainMenuControl();
    }

    private static void mainStop() {
        isMainMenuRun = false;
    }

}

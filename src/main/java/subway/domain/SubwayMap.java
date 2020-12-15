package subway.domain;

import subway.Constant;
import subway.domain.data.LineRepository;
import subway.domain.data.StationRepository;
import subway.domain.menu.MainMenu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayMap {

    private Scanner scanner;
    private LineRepository lineRepository;
    private StationRepository stationRepository;

    public SubwayMap(Scanner scanner) {
        this.scanner = scanner;
        lineRepository = new LineRepository();
        stationRepository = new StationRepository();
        startService();
    }

    private void startService() {
        while (true) {
            OutputView.printMainView();
            String inputData = selectService();
            if (inputData.equals(MainMenu.END.getOrder())){
                return;
            }
            Services.doService(inputData, scanner);
        }
    }

    private String selectService() {
        try {
            OutputView.printAskingFunction(Constant.ASKING_FUNCTION_INPUT_FUNCTION_ORDER);
            return InputView.inputMainMenu(scanner);
        } catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            return selectService();
        }
    }


}

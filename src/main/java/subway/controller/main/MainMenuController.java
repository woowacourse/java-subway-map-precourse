package subway.controller.main;

import subway.exception.InvalidFunctionException;
import subway.repository.line.LineRepository;
import subway.repository.station.StationRepository;
import subway.view.inputView.InputView;
import subway.view.output.MainMenuView;
import subway.view.output.OutputView;

public class MainMenuController implements Runnable {

    private StationRepository stationRepository;
    private LineRepository lineRepository;

    public MainMenuController(StationRepository stationRepository, LineRepository lineRepository) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
    }

    @Override
    public void run() {
        while (true) {
            MainMenuView.printMenu(MainMenu.toMenuString());
            Runnable function = selectFunction();
            if(function == null) {
                break;
            }
            function.run();
        }
    }

    private Runnable selectFunction() {
        MainMenuView.chooseFunction();
        String input = InputView.scan();

        Runnable function;
        try {
            function = MainMenu.find(input);
        } catch (InvalidFunctionException e) {
            OutputView.print(e.getMessage());
            return selectFunction();
        }

        return function;
    }

    public static void main(String[] args) {
        new MainMenuController(null, null).run();
    }
}

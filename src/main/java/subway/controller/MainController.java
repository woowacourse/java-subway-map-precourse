package subway.controller;

import java.util.EnumMap;
import java.util.Map;
import subway.controller.subController.ApplicationExitController;
import subway.controller.subController.Controllable;
import subway.controller.subController.InitializingController;
import subway.controller.subController.LineManagementController;
import subway.controller.subController.PrintSubwayMapController;
import subway.controller.subController.SectionManagementController;
import subway.controller.subController.StationManagementController;
import subway.domain.option.MainOption;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {
    private final Map<MainOption, Controllable> controllers;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.controllers = new EnumMap<>(MainOption.class);
        initializeControllers();
    }

    private void initializeControllers() {
        controllers.put(MainOption.STATION_MANAGEMENT, new StationManagementController(inputView, outputView));
        controllers.put(MainOption.LINE_MANAGEMENT, new LineManagementController(inputView, outputView));
        controllers.put(MainOption.SECTION_MANAGEMENT, new SectionManagementController(inputView, outputView));
        controllers.put(MainOption.PRINT_SUBWAY_MAP, new PrintSubwayMapController(inputView, outputView));
        controllers.put(MainOption.APPLICATION_EXIT, new ApplicationExitController(inputView, outputView));
    }


    public void service() {
        new InitializingController().process();
        MainOption mainOption;
        do {
            outputView.printMainScreen();
            mainOption = inputView.readMainOption();
            progress(mainOption);
        } while (mainOption.isPlayable());
    }

    public void progress(MainOption mainOption) {
        try {
            controllers.get(mainOption).process();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

}

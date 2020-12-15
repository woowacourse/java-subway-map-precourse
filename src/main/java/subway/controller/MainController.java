package subway.controller;

import subway.controller.enums.ModeType;
import subway.controller.mode.LineManagementMode;
import subway.controller.mode.SectionManagementMode;
import subway.controller.mode.StationManagementMode;
import subway.service.SubwayMapPrintService;
import subway.view.inputview.MainInputView;
import subway.view.outputview.LineManagementOutputView;
import subway.view.outputview.MainOutputView;
import subway.view.outputview.SectionManagementOutputView;
import subway.view.outputview.StationManagementOutputView;

import java.util.Scanner;

public class MainController {
    private final MainOutputView mainOutputView;
    private final MainInputView mainInputView;
    private final StationManagementMode stationManagementMode;
    private final LineManagementMode lineManagementMode;
    private final SectionManagementMode sectionManagementMode;
    private final SubwayMapPrintService subwayMapPrintService;
    private String modeType;
    public static final String EXIT = "Q";

    public MainController(Scanner scanner, MainOutputView mainOutputView) {
        this.mainInputView = new MainInputView(scanner);
        this.mainOutputView = mainOutputView;
        this.stationManagementMode = new StationManagementMode(scanner, new StationManagementOutputView());
        this.lineManagementMode = new LineManagementMode(scanner, new LineManagementOutputView());
        this.sectionManagementMode = new SectionManagementMode(scanner, new SectionManagementOutputView());
        this.subwayMapPrintService = new SubwayMapPrintService(mainOutputView);
    }

    public void run() {
        while (true) {
            this.mainInputView.showOptions();
            this.modeType = getModeType();

            if (this.modeType.toUpperCase().equals(EXIT)) {
                this.mainOutputView.printProgramExit();
                return;
            }

            selectMode();
        }
    }

    private String getModeType() {
        String modeCommand;

        try {
            modeCommand = this.mainInputView.inputCommand();
        } catch (IllegalArgumentException e) {
            this.mainOutputView.printErrorMessage(e.getMessage());
            return getModeType();
        }

        return modeCommand;
    }

    private void selectMode() {
        if (this.modeType.equals(ModeType.STATION_MANAGEMENT_MODE.getMode())) {
            this.stationManagementMode.run();
        }

        if (this.modeType.equals(ModeType.LINE_MANAGEMENT_MODE.getMode())) {
            this.lineManagementMode.run();
        }

        if (this.modeType.equals(ModeType.SECTION_MANAGEMENT_MODE.getMode())) {
            this.sectionManagementMode.run();
        }

        if (this.modeType.equals(ModeType.PRINT_MODE.getMode())) {
            this.subwayMapPrintService.printSubwayMap();
        }
    }
}

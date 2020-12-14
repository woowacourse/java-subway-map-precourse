package subway;

import subway.domain.line.LineService;
import subway.domain.section.SectionService;
import subway.domain.station.StationService;
import subway.service.input.InputService;
import subway.service.output.OutputService;
import subway.view.*;

public class StationManageApp {
    private final InputService inputService;
    private final OutputService outputService;
    private final StationService stationService;
    private final LineService lineService;
    private final SectionService sectionService;
    private final StationManage stationManage;
    private final LineManage lineManage;
    private final SectionManage sectionManage;


    public StationManageApp(StationManageConfig stationManageConfig) {
        this.inputService = stationManageConfig.inputService();
        this.outputService = stationManageConfig.outputService();
        this.stationService = stationManageConfig.stationService();
        this.lineService = stationManageConfig.lineService();
        this.sectionService = stationManageConfig.sectionService();
        this.stationManage = new StationManage(inputService, outputService, stationService);
        this.lineManage = new LineManage(inputService, outputService, sectionService, lineService, stationService);
        this.sectionManage = new SectionManage(inputService, outputService, sectionService, stationService);
    }

    public static StationManageApp of(StationManageConfig stationManageConfig) {
        return new StationManageApp(stationManageConfig);
    }

    public void startManage() {
        MainView mainView = new MainView(outputService);
        while (true) {
            int option;
            mainView.showOptions();
            try {
                option = inputService.getMainOption();
                checkOptions(option);
            } catch (Exception exception) {
                System.out.println(Prefix.ENTER.getPrefix() + exception.getMessage());
                continue;
            }
            if (isQuit(option)) {
                break;
            }
        }
    }

    private void checkOptions(int mainOption) {
        while (true) {
            try {
                chooseOptions(mainOption);
                break;
            } catch (Exception exception) {
                System.out.println(Prefix.ENTER.getPrefix() + exception.getMessage());
                continue;
            }
        }
    }

    private void chooseOptions(int mainOption) {
        if (mainOption == InputService.MANAGE_STATION) {
            stationManage.startMange();
        }
        if (mainOption == InputService.MANAGE_LINE) {
            lineManage.startManage();
        }
        if (mainOption == InputService.MANAGE_SECTION) {
            sectionManage.startManage();
        }
        if (mainOption == InputService.MANAGE_MAP) {
            sectionManage.showMap();
        }
    }

    private boolean isQuit(int option) {
        if (option == InputService.OPTION_QUIT) {
            return true;
        }
        return false;
    }
}

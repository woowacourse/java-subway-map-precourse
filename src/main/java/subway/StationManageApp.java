package subway;

import subway.service.input.InputService;
import subway.service.output.OutputService;
import subway.view.MainView;
import subway.view.Prefix;

public class StationManageApp {
    private final InputService inputService;
    private final OutputService outputService;
    private static Manage stationManage;
    private static Manage lineManage;
    private static Manage sectionManage;

    private StationManageApp(StationManageConfig stationManageConfig) {
        this.inputService = stationManageConfig.inputService();
        this.outputService = stationManageConfig.outputService();
        this.stationManage = stationManageConfig.stationManage();
        this.lineManage = stationManageConfig.lineManage();
        this.sectionManage = stationManageConfig.sectionManage();
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
            stationManage.startManage();
        }
        if (mainOption == InputService.MANAGE_LINE) {
            lineManage.startManage();
        }
        if (mainOption == InputService.MANAGE_SECTION) {
            sectionManage.startManage();
        }
        if (mainOption == InputService.MANAGE_MAP) {
            sectionManage.showStatus();
        }
    }

    private boolean isQuit(int option) {
        if (option == InputService.OPTION_QUIT) {
            return true;
        }
        return false;
    }
}

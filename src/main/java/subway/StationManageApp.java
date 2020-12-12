package subway;

import subway.domain.line.LineService;
import subway.domain.line.LineServiceImpl;
import subway.domain.line.MemoryLineRepository;
import subway.domain.section.MemorySectionRepository;
import subway.domain.section.SectionService;
import subway.domain.section.dto.SectionDeleteReqDto;
import subway.domain.section.dto.SectionSaveReqDto;
import subway.domain.station.MemoryStationRepository;
import subway.domain.station.StationService;
import subway.domain.station.StationServiceImpl;
import subway.domain.station.dto.StationDeleteReqDto;
import subway.domain.station.dto.StationSaveReqDto;
import subway.exception.ErrorCode;
import subway.exception.StationException;
import subway.service.input.InputService;
import subway.service.input.ScannerInputService;
import subway.service.output.OutputService;
import subway.service.output.StringBuilderOutputService;
import subway.view.LineView;
import subway.view.StationView;

import java.util.Scanner;

public class StationManageApp {
    private final InputService inputService;
    private final OutputService outputService;
    private final StationService stationService;
    private final LineService lineService;
    private final SectionService sectionService;

    public StationManageApp() {
        this.inputService = ScannerInputService.of(new Scanner(System.in));
        this.outputService = StringBuilderOutputService.of(new StringBuilder());
        this.stationService = new StationServiceImpl(MemoryStationRepository.of(), MemorySectionRepository.of());
        this.lineService = new LineServiceImpl(MemoryLineRepository.of());
        this.sectionService = new SectionService(MemoryLineRepository.of(), MemoryStationRepository.of(), MemorySectionRepository.of());
    }

    public static StationManageApp of() {
        return new StationManageApp();
    }

    public void startManage() {
        while (true) {
            outputService.printMain();
            int option = inputService.getMainOption();
            if (isQuit(option)) {
                break;
            }
            chooseOption(option);
        }
    }

    private boolean isQuit(int option) {
        if (option == InputService.OPTION_QUIT) {
            return true;
        }
        return false;
    }

    private boolean isBack(int manageStationOption) {
        if (manageStationOption == InputService.OPTION_BACK) {
            return true;
        }
        return false;
    }

    private void chooseOption(int mainOption) {
        if (mainOption == InputService.MANAGE_STATION) {
            manageStation();
        }
        if (mainOption == InputService.MANAGE_ROUTE) {
            manageRoute();
        }
        if (mainOption == InputService.MANAGE_SECTION) {
            mangeSection();
        }
        if (mainOption == InputService.MANAGE_MAP) {
            manageMap();
        }
    }

    private void chooseManageStationOption(int manageStationOption) {
        StationView stationView = new StationView(outputService);

        if (manageStationOption == InputService.ADD) {
            addStation(stationView);
        }
        if (manageStationOption == InputService.DELETE) {
            deleteStation(stationView);
        }
        if (manageStationOption == InputService.FIND) {
            stationView.printAllStations(stationService.getStations());
        }
    }

    private void addStation(StationView stationView) {
        outputService.printAdd(stationView);
        String stationName = getName();
        stationService.saveStation(new StationSaveReqDto(stationName));
        outputService.printAfterAdd(stationView);
    }

    private void deleteStation(StationView stationView) {
        outputService.printDelete(stationView);
        String stationName = getName();
        stationService.deleteStation(new StationDeleteReqDto(stationName));
        outputService.printAfterDelete(stationView);
    }

    private void chooseManageRouteOption(int manageRouteOption) {
        LineView lineView = new LineView(outputService);

        if (manageRouteOption == InputService.ADD) {
            addSection(lineView);
        }
        if (manageRouteOption == InputService.DELETE) {
            deleteSection(lineView);
        }
        if (manageRouteOption == InputService.FIND) {
            lineView.printAllLines(lineService.getLines());
        }
    }

    private void deleteSection(LineView lineView) {
        outputService.printDelete(lineView);
        String lineName = getName();
        sectionService.deleteByName(new SectionDeleteReqDto(lineName));
        outputService.printAfterAdd(lineView);
    }

    private void addSection(LineView lineView) {
        String lineName = getLineName(lineView);
        String upwardName = getUpwardName(lineView);
        String downWard = getDownwardName(lineView);

        sectionService.saveSection(new SectionSaveReqDto(lineName, upwardName, downWard));
        outputService.printAfterAdd(lineView);
    }

    private String getDownwardName(LineView lineView) {
        outputService.printSharp(lineView.getAddDownward());
        String downwardName = inputService.getName();
        return downwardName;
    }

    private String getUpwardName(LineView lineView) {
        outputService.printSharp(lineView.getAddUpward());
        String upwardName = inputService.getName();
        return upwardName;
    }

    private String getLineName(LineView lineView) {
        outputService.printAdd(lineView);
        String lineName = inputService.getName();
        return lineName;
    }

    private String getName() {
        String name = inputService.getName();
        return name;
    }

    private void manageMap() {
    }

    private void mangeSection() {
        outputService.printManageSection();
    }

    private void manageRoute() {
        outputService.printManageRoute();
        int manageRouteOption = inputService.getManageRouteOption();
        if (isBack(manageRouteOption)) {
            return;
        }
        chooseManageRouteOption(manageRouteOption);
    }

    private void manageStation() {
        outputService.printManageStation();
        int manageStationOption = inputService.getManageStationOption();
        if (isBack(manageStationOption)) {
            return;
        }
        chooseManageStationOption(manageStationOption);
    }
}

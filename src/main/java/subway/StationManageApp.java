package subway;

import subway.domain.line.LineService;
import subway.domain.section.Section;
import subway.domain.section.SectionService;
import subway.domain.section.dto.SectionDeleteReqDto;
import subway.domain.section.dto.SectionSaveReqDto;
import subway.domain.station.Station;
import subway.domain.station.StationService;
import subway.domain.station.dto.StationDeleteReqDto;
import subway.domain.station.dto.StationSaveReqDto;
import subway.service.input.InputService;
import subway.service.output.OutputService;
import subway.view.LineView;
import subway.view.SectionView;
import subway.view.StationView;

import java.util.List;

public class StationManageApp {
    private final InputService inputService;
    private final OutputService outputService;
    private final StationService stationService;
    private final LineService lineService;
    private final SectionService sectionService;

    public StationManageApp(StationManageConfig stationManageConfig) {
        this.inputService = stationManageConfig.inputService();
        this.outputService = stationManageConfig.outputService();
        this.stationService = stationManageConfig.stationService();
        this.lineService = stationManageConfig.lineService();
        this.sectionService = stationManageConfig.sectionService();
    }

    public static StationManageApp of(StationManageConfig stationManageConfig) {
        return new StationManageApp(stationManageConfig);
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
            addLine(lineView);
        }
        if (manageRouteOption == InputService.DELETE) {
            deleteLine(lineView);
        }
        if (manageRouteOption == InputService.FIND) {
            lineView.printAllLines(lineService.getLines());
        }
    }

    private void chooseManageSectionOption(int manageSectionOption) {
        SectionView sectionView = new SectionView(outputService);

        if (manageSectionOption == InputService.ADD) {
            addSection(sectionView);
        }
        if (manageSectionOption == InputService.DELETE) {
        }
    }

    private void addSection(SectionView sectionView) {
        outputService.printAdd(sectionView);
        Section section = sectionService.findByName(getName());
        int stationsLength = section.getStationsLength();

        outputService.printSharp(SectionView.PRINT_ADD_STATION);
        Station station = stationService.findByName(getName());
        sectionService.validateStation(section.getLineName(), station.getName());

        outputService.printSharp(SectionView.PRINT_ADD_SEQUENCE);
        outputService.printSharp(String.format(SectionView.PRINT_AVAILABLE_SEQUENCE, stationsLength + SectionService.CONVERT_SEQUENCE, stationsLength + SectionService.CONVERT_SEQUENCE));
        int sequence = inputService.getSequence();
        sectionService.addStation(section.getLineName(), station.getName(), sequence);
        outputService.printAfterAdd(sectionView);
    }

    private void deleteLine(LineView lineView) {
        outputService.printDelete(lineView);
        String lineName = getName();
        sectionService.deleteByName(new SectionDeleteReqDto(lineName));
        outputService.printAfterDelete(lineView);
    }

    private void addLine(LineView lineView) {
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
        SectionView sectionView = new SectionView(outputService);
        List<Section> sections = sectionService.findAll();
        sectionView.printAllSection(sections);
    }

    private void mangeSection() {
        outputService.printManageSection();
        int manageSectionOption = inputService.getManageSectionOption();
        if (isBack(manageSectionOption)) {
            return;
        }
        chooseManageSectionOption(manageSectionOption);
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

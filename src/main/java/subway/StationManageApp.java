package subway;

import subway.domain.line.LineService;
import subway.domain.section.Section;
import subway.domain.section.SectionService;
import subway.domain.section.dto.SectionDeleteReqDto;
import subway.domain.section.dto.SectionSaveReqDto;
import subway.domain.section.dto.SectionStationAddReqDto;
import subway.domain.section.dto.SectionStationDeleteReqDto;
import subway.domain.station.Station;
import subway.domain.station.StationService;
import subway.domain.station.dto.StationDeleteReqDto;
import subway.domain.station.dto.StationSaveReqDto;
import subway.service.input.InputService;
import subway.service.output.OutputService;
import subway.view.*;

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
            manageStation();
        }
        if (mainOption == InputService.MANAGE_LINE) {
            manageLine();
        }
        if (mainOption == InputService.MANAGE_SECTION) {
            mangeSection();
        }
        if (mainOption == InputService.MANAGE_MAP) {
            manageMap();
        }
    }

    private void manageStation() {
        StationView stationView = new StationView(outputService);
        stationView.showOptions();
        int manageStationOption = inputService.getManageStationOption();
        chooseManageStationOption(manageStationOption, stationView);
        if (isBack(manageStationOption)) {
            return;
        }
    }

    private void manageLine() {
        LineView lineView = new LineView(outputService);
        lineView.showOptions();
        int manageLineOption = inputService.getManageLineOption();
        chooseManageLineOption(manageLineOption, lineView);
        if (isBack(manageLineOption)) {
            return;
        }
    }

    private void mangeSection() {
        SectionView sectionView = new SectionView(outputService);
        sectionView.showOptions();
        int manageSectionOption = inputService.getManageSectionOption();
        chooseManageSectionOption(manageSectionOption, sectionView);
        if (isBack(manageSectionOption)) {
            return;
        }
    }

    private void manageMap() {
        SectionView sectionView = new SectionView(outputService);
        List<Section> sections = sectionService.findAll();
        sectionView.printAllSection(sections);
    }

    private void chooseManageStationOption(int manageStationOption, StationView stationView) {
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
        stationView.showAdd();
        String stationName = getName();
        stationService.saveStation(new StationSaveReqDto(stationName));
        stationView.showAfterAdd();
    }

    private void deleteStation(StationView stationView) {
        stationView.showDelete();
        String stationName = getName();
        stationService.deleteStation(new StationDeleteReqDto(stationName));
        stationView.showAfterDelete();
    }

    private void chooseManageLineOption(int manageLineOption, LineView lineView) {
        if (manageLineOption == InputService.ADD) {
            addLine(lineView);
        }
        if (manageLineOption == InputService.DELETE) {
            deleteLine(lineView);
        }
        if (manageLineOption == InputService.FIND) {
            lineView.printAllLines(lineService.getLines());
        }
    }

    private void addLine(LineView lineView) {
        String lineName = getLineName(lineView);
        String upwardName = getUpwardName(lineView);
        String downWard = getDownwardName(lineView);

        sectionService.saveSection(new SectionSaveReqDto(lineName, upwardName, downWard));
        lineView.showAfterAdd();
    }

    private void deleteLine(LineView lineView) {
        lineView.showDelete();
        String lineName = getName();
        sectionService.deleteSection(new SectionDeleteReqDto(lineName));
        lineView.showAfterDelete();
    }

    private void chooseManageSectionOption(int manageSectionOption, SectionView sectionView) {
        if (manageSectionOption == InputService.ADD) {
            addSection(sectionView);
        }
        if (manageSectionOption == InputService.DELETE) {
            deleteSection(sectionView);
        }
    }

    private void addSection(SectionView sectionView) {
        sectionView.showAdd();
        Section section = sectionService.findByName(getName());
        int stationsLength = section.getStationsLength();

        sectionView.showAddStation();
        Station station = stationService.findByName(getName());
        sectionService.checkContainStation(section, station);

        sectionView.showAddSequence();
        sectionView.showAvailableSequence(stationsLength);
        int sequence = inputService.getSequence();
        sectionService.addStation(new SectionStationAddReqDto(section.getLineName(), station.getName(), sequence));
        sectionView.showAfterAdd();
    }

    private void deleteSection(SectionView sectionView) {
        sectionView.showDelete();
        String lineName = getName();
        Section section = sectionService.findByName(lineName);

        sectionView.showDeleteStation();
        String stationName = getName();
        Station station = stationService.findByName(stationName);
        sectionService.deleteStation(new SectionStationDeleteReqDto(section.getLineName(), station.getName()));
        sectionView.showAfterDelete();
    }

    private String getDownwardName(LineView lineView) {
        lineView.showAddDownward();
        String downwardName = inputService.getName();
        stationService.checkNotFound(downwardName);
        return downwardName;
    }

    private String getUpwardName(LineView lineView) {
        lineView.showAddUpward();
        String upwardName = inputService.getName();
        stationService.checkNotFound(upwardName);
        return upwardName;
    }

    private String getLineName(LineView lineView) {
        lineView.showAdd();
        String lineName = inputService.getName();
        lineService.checkExist(lineName);
        return lineName;
    }

    private String getName() {
        String name = inputService.getName();
        return name;
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
}

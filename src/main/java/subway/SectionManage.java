package subway;

import subway.domain.section.Section;
import subway.domain.section.SectionService;
import subway.domain.section.dto.SectionStationAddReqDto;
import subway.domain.section.dto.SectionStationDeleteReqDto;
import subway.domain.station.Station;
import subway.domain.station.StationService;
import subway.service.input.InputService;
import subway.view.SectionView;

import java.util.List;

public class SectionManage implements Manage {
    private final InputService inputService;
    private final SectionService sectionService;
    private final StationService stationService;
    private final SectionView sectionView;

    public SectionManage(InputService inputService, SectionService sectionService, StationService stationService, SectionView sectionView) {
        this.inputService = inputService;
        this.sectionService = sectionService;
        this.stationService = stationService;
        this.sectionView = sectionView;
    }

    @Override
    public void startManage() {
        sectionView.showOptions();
        int manageSectionOption = inputService.getManageSectionOption();
        chooseManageSectionOption(manageSectionOption);
        if (isBack(manageSectionOption)) {
            return;
        }
    }

    @Override
    public void showStatus() {
        List<Section> sections = sectionService.findAll();
        sectionView.printAllSection(sections);
    }

    private void chooseManageSectionOption(int manageSectionOption) {
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

    private String getName() {
        String name = inputService.getName();
        return name;
    }

    private boolean isBack(int manageStationOption) {
        if (manageStationOption == InputService.OPTION_BACK) {
            return true;
        }
        return false;
    }
}

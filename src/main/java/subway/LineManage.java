package subway;

import subway.domain.line.LineService;
import subway.domain.section.SectionService;
import subway.domain.section.dto.SectionDeleteReqDto;
import subway.domain.section.dto.SectionSaveReqDto;
import subway.domain.station.StationService;
import subway.service.input.InputService;
import subway.service.output.OutputService;
import subway.view.LineView;

public class LineManage {
    private final InputService inputService;
    private final OutputService outputService;
    private final SectionService sectionService;
    private final LineService lineService;
    private final StationService stationService;

    public LineManage(InputService inputService, OutputService outputService, SectionService sectionService, LineService lineService, StationService stationService) {
        this.inputService = inputService;
        this.outputService = outputService;
        this.sectionService = sectionService;
        this.lineService = lineService;
        this.stationService = stationService;
    }

    public void startManage() {
        LineView lineView = new LineView(outputService);
        lineView.showOptions();
        int manageLineOption = inputService.getManageLineOption();
        chooseManageLineOption(manageLineOption, lineView);
        if (isBack(manageLineOption)) {
            return;
        }
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

    private boolean isBack(int manageStationOption) {
        if (manageStationOption == InputService.OPTION_BACK) {
            return true;
        }
        return false;
    }
}

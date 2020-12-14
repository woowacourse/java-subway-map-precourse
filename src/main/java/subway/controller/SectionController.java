package subway.controller;

import subway.domain.entity.Station;
import subway.dto.SectionDto;
import subway.service.LineService;
import subway.service.StationService;
import subway.view.InputView;
import subway.vo.FunctionType;

public class SectionController implements SubwayMapController {

    private final StationService stationService;
    private final LineService lineService;
    private final InputView inputView = InputView.getInstance();

    public SectionController(StationService stationService, LineService lineService) {
        this.stationService = stationService;
        this.lineService = lineService;
    }

    @Override
    public void register() {
        SectionDto sectionDto = inputView.inputSectionRequest(FunctionType.REGISTER);
        String stationName = sectionDto.getStationName();
        Station station = stationService.findStationByName(stationName);
        lineService.addSection(sectionDto, station);
    }

    @Override
    public void delete() {
        SectionDto sectionDto = inputView.inputSectionRequest(FunctionType.DELETE);
        lineService.deleteSection(sectionDto);

    }

    @Override
    public void readNames() {
    }

    @Override
    public void readEntireSubwayMap() {
    }
}

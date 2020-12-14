package subway.controller;

import subway.domain.entity.Station;
import subway.domain.type.FunctionType;
import subway.dto.SectionDto;
import subway.service.LineService;
import subway.service.StationService;
import subway.view.InputView;

public class SectionController implements SubwayMapController2 {

    private final StationService stationService;
    private final LineService lineService;
    private final InputView inputView;

    public SectionController(StationService stationService, LineService lineService, InputView inputView) {
        this.stationService = stationService;
        this.lineService = lineService;
        this.inputView = inputView;
    }

    @Override
    public void add() {
        SectionDto sectionDto = inputView.inputSectionRequest(FunctionType.DELETE);
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
    public void read() {
    }
}

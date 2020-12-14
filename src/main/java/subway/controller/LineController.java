package subway.controller;

import subway.domain.entity.Sections;
import subway.domain.type.FunctionType;
import subway.domain.type.ManagementType;
import subway.dto.LineDto;
import subway.dto.SubwayMapDto;
import subway.service.LineService;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class LineController implements SubwayMapController {

    private final StationService stationService;
    private final LineService lineService;
    private final InputView inputView = InputView.getInstance();

    public LineController(StationService stationService, LineService lineService) {
        this.stationService = stationService;
        this.lineService = lineService;
    }

    @Override
    public void register() {
        LineDto lineDto = inputView.inputLineRequest(ManagementType.LINE, FunctionType.REGISTER);
        String lineName = lineDto.getLineName();
        Sections sections = stationService.createSections(lineDto);
        lineService.addLine(lineName, sections);
    }

    @Override
    public void delete() {
        String lineName = inputView.inputName(ManagementType.LINE, FunctionType.DELETE);
        lineService.deleteLineByName(lineName);
    }

    @Override
    public void readNames() {
        List<String> lineNames = lineService.getLineNames();
        OutputView.printNames(ManagementType.LINE, lineNames);
    }

    @Override
    public void readSubwayMap() {
        List<SubwayMapDto> subwayMapDtos = lineService.getSubwayMapDtos();
        OutputView.printSubwayMap(subwayMapDtos);
    }
}

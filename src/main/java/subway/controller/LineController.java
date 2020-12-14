package subway.controller;

import subway.domain.entity.Sections;
import subway.domain.type.FunctionType;
import subway.domain.type.ManagementType;
import subway.dto.LineDto;
import subway.service.LineService;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class LineController implements SubwayMapController2 {

    private final StationService stationService;
    private final LineService lineService;
    private final InputView inputView;

    public LineController(StationService stationService, LineService lineService, InputView inputView) {
        this.stationService = stationService;
        this.lineService = lineService;
        this.inputView = inputView;
    }

    @Override
    public void add() {
        LineDto lineDto = inputView.inputLineRequest(FunctionType.REGISTER);
        String lineName = lineDto.getLineName();
        Sections sections = stationService.createSections(lineDto);
        lineService.addLine(lineName, sections);
    }

    @Override
    public void delete() {
        LineDto lineDto = inputView.inputLineRequest(FunctionType.DELETE);
        String lineName = lineDto.getLineName();
        lineService.deleteLineByName(lineName);
    }

    @Override
    public void read() {
        List<String> lineNames = lineService.getLineNames();
        OutputView.printNames(ManagementType.LINE, lineNames);
    }
}

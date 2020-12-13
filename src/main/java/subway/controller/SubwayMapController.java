package subway.controller;

import subway.domain.entity.Sections;
import subway.dto.LineDto;
import subway.service.LineService;
import subway.service.StationService;

import java.util.List;

public class SubwayMapController {

    private final StationService stationService;
    private final LineService lineService;

    public SubwayMapController(StationService stationService, LineService lineService) {
        this.stationService = stationService;
        this.lineService = lineService;
    }

    public void addStationByName(String stationName) {
        stationService.addStationByName(stationName);
    }

    public void deleteStationByName(String stationName) {
        stationService.deleteStationByName(stationName);
    }

    public void addLine(LineDto lineDto) {
        String lineName = lineDto.getLineName();
        Sections sections = stationService.createSections(lineDto);
        lineService.addLine(lineName, sections);
    }

    public List<String> getStationNames() {
        return stationService.getStationNames();
    }

    public List<String> getLineNames() {
        return lineService.getLineNames();
    }
}

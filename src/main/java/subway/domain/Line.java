package subway.domain;

import subway.exception.TerminalNamesOverlapException;
import subway.service.StationService;
import subway.view.Input;

public class Line {
    private String name;
    private Station upwardTerminalStation;
    private Station downTerminalStation;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void initTerminalStations() {
        Station upwardTerminalStation = StationService.isExists(
                Input.input(Input.PLEASE_INPUT_UPWARD_TERMINAL_STATION_MESSAGE));

        Station downTerminalStation = StationService.isExists(
                Input.input(Input.PLEASE_INPUT_DOWN_TERMINAL_STATION_MESSAGE));

        if (upwardTerminalStation.equals(downTerminalStation)) {
            throw new TerminalNamesOverlapException();
        }

        this.upwardTerminalStation = upwardTerminalStation;
        this.downTerminalStation = downTerminalStation;
    }

    @Override
    public String toString() {
        return name;
    }
}

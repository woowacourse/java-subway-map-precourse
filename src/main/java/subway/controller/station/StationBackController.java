package subway.controller.station;

import subway.domain.StationOption;

public class StationBackController implements SubStationController {
    @Override
    public StationOption process() {
        return StationOption.BACK;
    }
}

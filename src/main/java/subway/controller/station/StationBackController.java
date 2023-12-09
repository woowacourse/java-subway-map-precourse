package subway.controller.station;

public class StationBackController implements SubStationController {
    @Override
    public StationOption process() {
        return StationOption.BACK;
    }
}

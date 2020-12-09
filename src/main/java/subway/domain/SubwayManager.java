package subway.domain;

import subway.view.OutputView;

public class SubwayManager {
    public void addStation(String name) {
        StationRepository.addStation(new Station(name));
        OutputView.printRegisteredStationMessage();
    }
}

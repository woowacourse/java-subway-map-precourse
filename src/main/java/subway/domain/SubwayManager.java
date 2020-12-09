package subway.domain;

import subway.view.OutputView;

public class SubwayManager {
    public void addStation(String name) {
        StationRepository.addStation(new Station(name));
        OutputView.printRegisteredStationMessage();
    }

    public void removeStation(String name) {
        StationRepository.deleteStation(name);
        OutputView.printRemovedStationMessage();
    }

    public void inquiryStation() {
        OutputView.printStationList(StationRepository.stations());
    }

    public void addLine(String name) {
        LineRepository.addLine(new Line(name));
        OutputView.printRegisteredLineMessage();
    }

    public void removeLine(String name) {
        LineRepository.deleteLineByName(name);
        OutputView.printRemovedLineMessage();
    }
}

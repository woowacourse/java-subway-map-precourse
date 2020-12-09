package subway.domain;

import subway.view.OutputView;

import java.util.Scanner;

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

    public void addLine(String name, Scanner scanner) {
        Line line = new Line(name);

        OutputView.printInputRegisterLineUpStation();
        line.addStation(StationRepository.findStationByName(scanner.next()));
        OutputView.printInputRegisterLineDownStation();
        line.addStation(StationRepository.findStationByName(scanner.next()));

        LineRepository.addLine(line);
        OutputView.printRegisteredLineMessage();
    }

    private void setLineUpStation() {

    }

    private void setLineDownStation() {

    }

    public void removeLine(String name) {
        LineRepository.deleteLineByName(name);
        OutputView.printRemovedLineMessage();
    }
    
    public void inquiryLine() {
        OutputView.printLineList(LineRepository.lines());
    }
}

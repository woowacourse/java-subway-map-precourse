package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Subway {


    public Subway() {
    }

    public Station makeStation(String name) {
        return new Station(name);
    }

    public boolean containsStation(String name) {
        return StationRepository.contains(name);
    }

    public void addStation(String name) {
        Station station = new Station(name);
        StationRepository.addStation(station);
    }

    public boolean containsLine(String name) {
        return LineRepository.contains(name);
    }

    public void addLine(String name, String upStreamTerminal, String downStreamTerminal) {
        Line line = new Line(name);

        if (!StationRepository.contains(upStreamTerminal) || !StationRepository.contains(downStreamTerminal)) {
            return;
        }

        line.addStation(upStreamTerminal);
        line.addStation(downStreamTerminal);

        LineRepository.addLine(line);
    }
}

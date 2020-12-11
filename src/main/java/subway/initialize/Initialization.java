package subway.initialize;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Initialization {

    private static final int FIRST_INDEX = 0;
    private static final int PREVIOUS_INDEX = -1;

    public static void set() {
        Initialization initialization = new Initialization();
        initialization.registerStations();
        initialization.registerLines();
    }

    public void registerStations() {
        for (Pair pair : DefaultStations.getTotalDefaultStations()) {
            Station station = new Station(pair.getText());
            registerLinesInStation(pair.getValues(), station);
            StationRepository.addStation(station);
        }
    }

    public void registerLinesInStation(String[] lines, Station station) {
        for (String lineName : lines) {
            station.registerIn(lineName);
        }
    }

    public void registerLines() {
        for (Pair pair : DefaultLines.getTotalDefaultLines()) {
            Line line = new Line(
                    pair.getText(),
                    pair.getValues()[FIRST_INDEX],
                    pair.getValues()[pair.getValues().length + PREVIOUS_INDEX]
            );
            registerStationsInLine(pair.getValues(), line);
            LineRepository.addLine(line);
        }
    }

    public void registerStationsInLine(String[] stations, Line line) {
        for (String stationName : stations) {
            line.appendStation(stationName);
        }
    }

}

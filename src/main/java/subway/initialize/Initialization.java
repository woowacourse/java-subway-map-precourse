package subway.initialize;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Initialization {

    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
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
        // 상행 종점역과 하행 종점역의 중복 등록을 방지하기 위함
        for (int i = SECOND_INDEX; i < stations.length + PREVIOUS_INDEX; i++) {
            line.addOnLine(i, stations[i]);
        }
    }

}

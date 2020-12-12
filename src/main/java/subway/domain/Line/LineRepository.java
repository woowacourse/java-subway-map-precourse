package subway.domain.Line;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.exception.AlreadyAddLineException;
import subway.exception.LineNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    static {    //예시 추가

        StationRepository stationRepository = new StationRepository();

        stationRepository.addStation(Station.of("교대역"));
        stationRepository.addStation(Station.of("강남역"));
        stationRepository.addStation(Station.of("역삼역"));
        stationRepository.addStation(Station.of("남부터미널역"));
        stationRepository.addStation(Station.of("양재시민의숲역"));
        stationRepository.addStation(Station.of("양재역"));
        stationRepository.addStation(Station.of("매봉역"));

        Station station1 = stationRepository.findBy("교대역");
        Station station2 = stationRepository.findBy("강남역");
        Station station3 = stationRepository.findBy("역삼역");
        Station station4 = stationRepository.findBy("남부터미널역");
        Station station5 = stationRepository.findBy("양재역");
        Station station6 = stationRepository.findBy("매봉역");
        Station station7 = stationRepository.findBy("양재시민의숲역");

        LineRepository lineRepository = new LineRepository();
        Line line2 = Line.of("2호선", station1, station3);
        line2.addTo(1, station2);
        lineRepository.addLine(line2);

        Line line3 = Line.of("3호선", station1, station6);
        line3.addTo(1, station5);
        line3.addTo(1, station4);
        lineRepository.addLine(line3);

        Line lineBoon = Line.of("신분당선", station2, station7);
        lineBoon.addTo(1, station5);
        lineRepository.addLine(lineBoon);

        stationRepository.addStation(Station.of("갓우정역"));
        stationRepository.addStation(Station.of("킹우정역"));
        stationRepository.addStation(Station.of("우정역"));

        Station sample1 = stationRepository.findBy("갓우정역");
        Station sample2 = stationRepository.findBy("킹우정역");
        Station sample3 = stationRepository.findBy("우정역");

    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public Line findBy(String name) {
        return lines().stream()
                .filter(l -> l.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new LineNotFoundException(name));
    }

    public void addLine(Line line) {

        if (lines().contains(line)) {
            throw new AlreadyAddLineException(line.toString());
        }
        lines.add(line);
    }

    public boolean deleteLineByName(String name) {
        Line line = findBy(name);
        line.clear();
        return lines.remove(line);
    }

}

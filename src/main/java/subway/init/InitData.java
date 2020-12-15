package subway.init;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InitData {
    final static String stationNames[] = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    final static String lineNames[] = {"2호선", "3호선", "신분당선"};

    public static void startInitWork() {
        createStationAndLine();
        enrollStationToLine();
    }

    private static void createStationAndLine() {
        for (String stationName : stationNames) {
            StationRepository.addStation(new Station(stationName));
        }
        for (String lineName : lineNames) {
            LineRepository.addLine(new Line(lineName));
        }
    }

    private static void enrollStationToLine() {
        final Line line1 = LineRepository.findByName(lineNames[0]).get();
        line1.add(StationRepository.findByName(stationNames[0]).get());
        line1.add(StationRepository.findByName(stationNames[1]).get());
        line1.add(StationRepository.findByName(stationNames[2]).get());
        final Line line2 = LineRepository.findByName(lineNames[1]).get();
        line2.add(StationRepository.findByName(stationNames[0]).get());
        line2.add(StationRepository.findByName(stationNames[3]).get());
        line2.add(StationRepository.findByName(stationNames[4]).get());
        line2.add(StationRepository.findByName(stationNames[6]).get());
        final Line line3 = LineRepository.findByName(lineNames[2]).get();
        line3.add(StationRepository.findByName(stationNames[1]).get());
        line3.add(StationRepository.findByName(stationNames[4]).get());
        line3.add(StationRepository.findByName(stationNames[5]).get());
    }
}

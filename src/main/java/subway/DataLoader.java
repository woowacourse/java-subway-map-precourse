package subway;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.domain.station.StationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataLoader {
    private static final String[] DATA_STATION_NAMES = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static final String FIRST_DATA_LINE = "2호선";
    private static final String SECOND_DATA_LINE = "3호선";
    private static final String THIRD_DATA_LINE = "신분당선";

    public static void load() {
        List<StationName> stationNameData = Arrays.stream(DATA_STATION_NAMES)
                .map(stationName -> new StationName(stationName))
                .collect(Collectors.toList());

        for (int i = 0; i < stationNameData.size(); i++) {
            StationRepository.addStation(stationNameData.get(i));
        }

        Line lineData1 = Line.createLine(new LineName(FIRST_DATA_LINE), stationNameData.get(0), stationNameData.get(2));
        LineRepository.addLine(lineData1);
        lineData1.addStationToLine(Station.of(stationNameData.get(1)), 2);

        Line lineData2 = Line.createLine(new LineName(SECOND_DATA_LINE), stationNameData.get(0), stationNameData.get(6));
        LineRepository.addLine(lineData2);
        lineData2.addStationToLine(Station.of(stationNameData.get(3)), 2);
        lineData2.addStationToLine(Station.of(stationNameData.get(4)), 3);

        Line lineData3 = Line.createLine(new LineName(THIRD_DATA_LINE), stationNameData.get(1), stationNameData.get(5));
        LineRepository.addLine(lineData3);
        lineData3.addStationToLine(Station.of(stationNameData.get(4)), 2);
    }
}

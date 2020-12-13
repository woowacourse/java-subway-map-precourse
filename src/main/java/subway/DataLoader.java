package subway;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.domain.station.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataLoader {
    private static final String[] STATION_DATA_NAMES = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static final String[] LINE_DATA_NAMES = {"2호선", "3호선", "신분당선"};

    public static void load() {
        List<StationName> stationNameData = Arrays.stream(STATION_DATA_NAMES)
                .map(stationName -> new StationName(stationName))
                .collect(Collectors.toList());
        stationNameData.forEach(stationName -> StationRepository.addStation(Station.of(stationName)));

        List<StationName> firstLineDataStation = new ArrayList<>(Arrays.asList(stationNameData.get(0), stationNameData.get(1),
                stationNameData.get(2)));
        Line lineData1 = Line.of(new LineName(LINE_DATA_NAMES[0]), firstLineDataStation);
        LineRepository.addLine(lineData1);

        List<StationName> secondLineDataStation = new ArrayList<>(Arrays.asList(stationNameData.get(0), stationNameData.get(3),
                stationNameData.get(4), stationNameData.get(6)));
        Line lineData2 = Line.of(new LineName(LINE_DATA_NAMES[1]), secondLineDataStation);
        LineRepository.addLine(lineData2);

        List<StationName> thirdLineDataStation = new ArrayList<>(Arrays.asList(stationNameData.get(1), stationNameData.get(4),
                stationNameData.get(5)));
        Line lineData3 = Line.of(new LineName(LINE_DATA_NAMES[2]), thirdLineDataStation);
        LineRepository.addLine(lineData3);
    }
}

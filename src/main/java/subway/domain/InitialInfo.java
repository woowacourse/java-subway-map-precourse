package subway.domain;

import java.util.Arrays;
import java.util.List;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class InitialInfo {
    private final String[] initStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역",
        "양재시민의숲역", "매봉역"};
    private final String[] line2 = {"2호선", "교대역", "역삼역"};
    private final String[] line3 = {"3호선", "교대역", "매봉역"};
    private final String[] lineShin = {"신분당선", "강남역", "양재시민의숲역"};
    private final List<String[]> initLines = Arrays.asList(line2, line3, lineShin);
    private final String[] pathInfoLineTwoPathOne = {"2호선", "강남역", "2"};
    private final String[] pathInfoLineThreePathOne = {"3호선", "남부터미널역", "2"};
    private final String[] pathInfoLineThreePathTwo = {"3호선", "양재역", "3"};
    private final String[] pathInfoLineShinPathOne = {"신분당선", "양재역", "2"};
    private final List<String[]> initPaths = Arrays
        .asList(pathInfoLineTwoPathOne, pathInfoLineThreePathOne, pathInfoLineThreePathTwo,
            pathInfoLineShinPathOne);

    public InitialInfo() {
        initInfo();
    }

    private void initInfo() {
        setStations();
        setLines();
        setPaths();
    }

    private void setStations() {
        for (String station : initStations) {
            StationRepository.addStation(new Station(station));
        }
    }

    private void setLines() {
        for (String[] lineInfo : initLines) {
            SubwayRepository.createSubwayRealLine(lineInfo);
        }
    }

    private void setPaths() {
        for (String[] pathInfo : initPaths) {
            SubwayRepository.addPathByLineNameAndIndex(pathInfo);
        }
    }

}

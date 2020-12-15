package subway;

import subway.domain.StationFactory;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

import static subway.domain.LineFactory.makeLine;
import static subway.domain.LineRepository.addLine;
import static subway.domain.LineRepository.findLine;
import static subway.domain.SectionRepository.addSection;
import static subway.domain.StationRepository.findStationByName;

public class SubwayInitializer {
    public static final String COMMA = ",";
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;

    public static void init() {
        List<String> stations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        List<String> lineAndSequence = Arrays.asList(
                "2호선,교대역,강남역,역삼역"
                , "3호선,교대역,남부터미널역,양재역,매봉역"
                , "신분당선,강남역,양재역,양재시민의숲역"
        );
        makeStations(stations);
        makeLinesFromCsvData(lineAndSequence);
    }

    private static void makeLinesFromCsvData(List<String> lineAndSequence) {
        lineAndSequence.stream()
                .map(csvData -> Arrays.asList(csvData.split(COMMA)))
                .forEach(SubwayInitializer::makeLines);
    }

    private static void makeLines(List<String> lineAndStations) {
        String lineName = lineAndStations.get(ZERO);
        addLine(makeLine(lineName,
                findStationByName(lineAndStations.get(ONE)),
                findStationByName(lineAndStations.get(TWO))));

        for (int i = THREE; i < lineAndStations.size(); i++) {
            addSection(findLine(lineName), findStationByName(lineAndStations.get(i)), i - 1);
        }
    }

    private static void makeStations(List<String> stations) {
        stations.stream()
                .map(StationFactory::makeStation)
                .forEach(StationRepository::addStation);
    }
}

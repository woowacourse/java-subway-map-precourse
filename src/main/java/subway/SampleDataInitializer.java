package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 예시로 주어진 초기 데이터를 설정하는 클래스입니다.
 */
public class SampleDataInitializer {
    private static final String KYODAE = "교대역";
    private static final String GANGNAM = "강남역";
    private static final String YEOKSAM = "역삼역";
    private static final String NAMBU = "남부터미널역";
    private static final String YANGJAE = "양재역";
    private static final String YANGJAE_FOREST = "양재시민의숲역";
    private static final String MAEBONG = "매봉역";
    private static final String LINE_TWO = "2호선";
    private static final String LINE_THREE = "3호선";
    private static final String LINE_SHINBUNDANG = "신분당선";

    public static void initialStationRepository() {
        List<String> initialStations = new ArrayList<>(Arrays.asList(
                KYODAE, GANGNAM, YEOKSAM, NAMBU, YANGJAE, YANGJAE_FOREST, MAEBONG
        ));
        initialStations.stream()
                .map(Station::new)
                .forEach(StationRepository::addStation);
    }

    public static void initialLineRepository() {
        line2Initialize();
        line3Initialize();
        shinbundangLineInitialize();
    }

    private static void line2Initialize() {
        Line line2 = new Line(LINE_TWO,
                StationRepository.searchByName(KYODAE),
                StationRepository.searchByName(YEOKSAM));
        line2.addStation(2, StationRepository.searchByName(GANGNAM));

        LineRepository.addLine(line2);
    }

    private static void line3Initialize() {
        Line line3 = new Line(LINE_THREE,
                StationRepository.searchByName(KYODAE),
                StationRepository.searchByName(MAEBONG));
        line3.addStation(2, StationRepository.searchByName(NAMBU));
        line3.addStation(3, StationRepository.searchByName(YANGJAE));


        LineRepository.addLine(line3);
    }

    private static void shinbundangLineInitialize() {
        Line shinbundangLine = new Line(LINE_SHINBUNDANG,
                StationRepository.searchByName(GANGNAM),
                StationRepository.searchByName(YANGJAE_FOREST));
        shinbundangLine.addStation(2, StationRepository.searchByName(YANGJAE));

        LineRepository.addLine(shinbundangLine);
    }

}

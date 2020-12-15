package subway.util;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DefaultSetting {
    private static final String KYODAE = "교대역";
    private static final String GANGNAM = "강남역";
    private static final String YEOKSAM = "역삼역";
    private static final String NORTH_TERMINAL = "남부터미널역";
    private static final String YANGJAE = "양재역";
    private static final String YANGJAE_CITIZEN_FOREST = "양재시민의숲역";
    private static final String MAEBONG = "매봉역";
    private static final String LINE2 = "2호선";
    private static final String LINE3 = "3호선";
    private static final String SINBUNDANG_LINE = "신분당선";

    public void defaultSetting() {
        StationRepository.addStation(new Station(KYODAE));
        StationRepository.addStation(new Station(GANGNAM));
        StationRepository.addStation(new Station(YEOKSAM));
        StationRepository.addStation(new Station(NORTH_TERMINAL));
        StationRepository.addStation(new Station(YANGJAE));
        StationRepository.addStation(new Station(YANGJAE_CITIZEN_FOREST));
        StationRepository.addStation(new Station(MAEBONG));

        LineRepository.addLine(new Line(LINE2));
        LineRepository.addLine(new Line(LINE3));
        LineRepository.addLine(new Line(SINBUNDANG_LINE));

        Line line2 = LineRepository.findLineByName(LINE2);
        line2.addStation(KYODAE);
        line2.addStation(GANGNAM);
        line2.addStation(YEOKSAM);

        Line line3 = LineRepository.findLineByName(LINE3);
        line3.addStation(KYODAE);
        line3.addStation(NORTH_TERMINAL);
        line3.addStation(YANGJAE);
        line3.addStation(MAEBONG);

        Line dxLine = LineRepository.findLineByName(SINBUNDANG_LINE);
        dxLine.addStation(GANGNAM);
        dxLine.addStation(YANGJAE);
        dxLine.addStation(YANGJAE_CITIZEN_FOREST);
    }
}

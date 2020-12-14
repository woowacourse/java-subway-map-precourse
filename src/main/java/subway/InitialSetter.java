package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InitialSetter {
    public void setInitialSubwayInfo() {
        setInitialStation();
        setInitialLine();
    }

    private void setInitialStation() {
        String[] stations = { "교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역" };
        for (String station : stations) {
            StationRepository.addStation(new Station(station));
        }
    }

    private void setInitialLine() {
        setLineNo2(new Line("2호선"));
        setLineNo3(new Line("3호선"));
        setLineNewBundang(new Line("신분당선"));
    }

    private void setLineNo2(Line lineNo2) {
        lineNo2.addStation("교대역");
        lineNo2.addStation("강남역");
        lineNo2.addStation("역삼역");
        LineRepository.addLine(lineNo2);
    }

    private void setLineNo3(Line lineNo3) {
        lineNo3.addStation("교대역");
        lineNo3.addStation("남부터미널역");
        lineNo3.addStation("양재역");
        lineNo3.addStation("매봉역");
        LineRepository.addLine(lineNo3);
    }

    private void setLineNewBundang(Line lineNewBundang) {
        lineNewBundang.addStation("강남역");
        lineNewBundang.addStation("양재역");
        lineNewBundang.addStation("양재시민의숲역");
        LineRepository.addLine(lineNewBundang);
    }
}

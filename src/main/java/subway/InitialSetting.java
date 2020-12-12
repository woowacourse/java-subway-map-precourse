package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InitialSetting {
    public static void setInitialSubwayInfo() {
        setInitialStation();
        setInitialLine();
        setInitialMap();
    }

    private static void setInitialStation() {
        String[] stations = { "교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역" };
        for (String station : stations) {
            StationRepository.addStation(new Station(station));
        }
    }

    private static void setInitialLine() {
        String[] lines = { "2호선", "3호선", "신분당선" };
        for (String line : lines) {
            LineRepository.addLine(new Line(line));
        }
    }

    private static void setInitialMap() {
        // 초기 노선에 역 등록 기능 추가 예정
    }
}

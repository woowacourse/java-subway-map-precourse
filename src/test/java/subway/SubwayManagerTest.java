package subway;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.StationRepository;

class SubwayManagerTest {
    @Test
    public void 역과_노선에_등록된_역이_같은지_테스트() {
        Station station = new Station("양산역");
        StationRepository.addStation(station);

        // Station 객체를 새로 생성하여 LineRepository 에 저장
        Line line = new Line("2호선");
        line.addLineStation(0, new Station("양산역"));

        // LineRepository 의 "양산역" 과 station 의 "양산역"이 같은지 동일성 테스트
        Assertions.assertEquals(station, StationRepository.stations().stream()
                                           .filter(s -> s.getName().equals("양산역"))
                                            .findFirst()
                                            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 역이 없습니다.")));
    }
}
package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    public void 역_등록_후_노선_등록에_성공한다() throws Exception {
        //given
        Station startStation = new Station("서울역");
        Station endStation = new Station("부산역");
        StationRepository.addStation(startStation);
        StationRepository.addStation(endStation);

        //when
        Line line = new Line("1호선");
        LineRepository.addLine(line);
        LineStationRepository lineStation = new LineStationRepository(LineStationFactory.init());

        int beforeSize = lineStation.getLineStationSize();

        lineStation.addLineStation(line, StationRepository.findStation("서울역").get());
        lineStation.addLineStation(line, StationRepository.findStation("부산역").get());

        //then
        int afterSize = lineStation.getLineStationSize();
        Assertions.assertThat(beforeSize).isNotEqualTo(afterSize);
    }
}
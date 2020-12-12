package subway.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.Station;

import static org.junit.jupiter.api.Assertions.*;

class LineRepositoryTest {

    @Test
    @DisplayName("역이 노선에 등록했는지 확인할 수 있다")
    public void isExistStationInLineTest() throws Exception{
        //given
        Line line = new Line("2호선");
        Station station = new Station("잠실역");

        //when
        line.enrollStation(station);
        LineRepository.addLine(line);

        //then
        boolean result = LineRepository.isStationExistInLine(station);
        assertTrue(result);

    }

}
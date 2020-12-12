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
        Line line = new Line("2호선", null, null);
        Station station = new Station("잠실역");

        //when
        line.enrollStation(station);
        LineRepository.addLine(line);

        //then
        boolean result = LineRepository.isStationExistInLine(station);
        assertTrue(result);
    }

    @Test
    @DisplayName("중복 이름의 노선은 등록될 수 없다")
    public void duplicateLineAddTest() throws Exception{
        Line line = new Line("bepoz", null, null);
        LineRepository.addLine(line);

        Line line2 = new Line("bepoz", null, null);
        assertFalse(LineRepository.addLine(line2));
    }

}
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

    @Test
    @DisplayName("구간을 추가할 수 있다")
    public void addSectionTest() throws Exception{
        Line line = new Line("bepoz", new Station("잠실역"), new Station("당산역"));
        LineRepository.addSection(line, new Station("구간추가역"), 1);
        line.getStationList()
                .forEach(station -> System.out.println(station.getName()));
    }

    @Test
    @DisplayName("구간을 삭제할 수 있다")
    public void deleteSectionTest() throws Exception{
        Line line = new Line("bepoz", new Station("잠실역"), new Station("당산역"));
        LineRepository.addSection(line, new Station("구간추가역"), 1);
        assertTrue(LineRepository.deleteSection(line, new Station("구간추가역")));
    }

    @Test
    @DisplayName("역이 2개 이하인 노선은 구간을 삭제할 수 없다")
    public void deleteSectionFailTest() throws Exception{
        Line line = new Line("bepoz", new Station("잠실역"), new Station("당산역"));
        assertFalse(LineRepository.deleteSection(line, new Station("잠실역")));
    }

}
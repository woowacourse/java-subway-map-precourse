package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("노선이 잘 생성되는 지 확인")
    public void createLine() throws Exception {
        //given
        String lineName = "1호선";
        //when
        Line line = createDummyLine();
        //then
        Assertions.assertEquals(lineName, line.getName());
    }

    @Test
    @DisplayName("순서가 너무 컸을 때 역 등록 실패")
    public void joinStatinFail() throws Exception{
        //given
        String expectedMessage = "순서가 너무 큽니다. 등록되어 있는 역 수 : 2";
        Line line = createDummyLine();
        Station station = Station.from("도봉산역");
        int index = 4;
        //when
        IllegalStateException illegalStateException =
                Assertions.assertThrows(IllegalStateException.class, () -> line.joinStation(station, index));
        //then
        Assertions.assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("노선에 역 등록")
    public void joinStationSuccess() throws Exception {
        //given
        Line line = createDummyLine();
        Station station = Station.from("도봉산역");
        int index = 3;
        //when
        line.joinStation(station, index);
        //then
        Assertions.assertFalse(station.isRemovable());
        Assertions.assertTrue(line.stations().contains(station));
    }

    @Test
    @DisplayName("제거할 수 없는 역 삭제")
    public void removeStationFail() throws Exception{
        //given
        String expectedMessage = "노선을 유지하려면 최소 둘 이상의 역이 등록되어 있어야 합니다.";
        Line line = createDummyLine();
        Station existStation = Station.from("의정부역");
        //when
        IllegalStateException illegalStateException =
                Assertions.assertThrows(IllegalStateException.class, () -> line.removeStation(existStation));
        //then
        Assertions.assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("제거 가능 역 삭제")
    public void removeStationSuccess() throws Exception{
        //given
        Line line = createDummyLine();
        Station station = Station.from("도봉산역");
        line.joinStation(station, 1);
        //when
        line.removeStation(station);
        //then
        Assertions.assertTrue(station.isRemovable());
        Assertions.assertFalse(line.stations().contains(station));
    }


    private Line createDummyLine() {
        Station start = Station.from("의정부역");
        Station end = Station.from("회룡역");
        String lineName = "1호선";
        return Line.of(lineName, start, end);
    }
}
package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {

    @Test
    @DisplayName("지하철 역 이름이 유효성 검사를 통과하지 못 할 경우")
    public void testWrongName() throws Exception {
        //given
        final int MIN_NAME_LENGTH = 2;
        final String WRONG_NAME = "하";
        final String ERROR_MESSAGE = "지하철 역 이름은 %d 글자 이상이어야 합니다.";
        //when
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> new Station(WRONG_NAME));
        //then
        Assertions.assertEquals(String.format(ERROR_MESSAGE, MIN_NAME_LENGTH), illegalStateException.getMessage());
    }

    @Test
    public void testUnremovableStation() throws Exception {
        //given
        Station station = createStation();
        station.addLine();
        //when
        boolean removable = station.isRemovable();
        //then
        Assertions.assertFalse(removable);
    }

    @Test
    public void testRemovableStation() throws Exception {
        //given
        Station station = createStation();
        //when
        boolean removable = station.isRemovable();
        //then
        Assertions.assertTrue(removable);
    }

    private Station createStation() {
        String name = "테스트";
        return new Station(name);
    }

}
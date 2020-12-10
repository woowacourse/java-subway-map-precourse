package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StationTest {

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
        return Station.from(name);
    }

}
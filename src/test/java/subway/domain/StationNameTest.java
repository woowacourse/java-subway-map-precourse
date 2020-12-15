package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StationNameTest {

    @Test
    public void testCase1_isCorrectStationName() {
        //GIVEN
        String name = "방배역";

        //WHEN
        boolean actualResult = true;
        try {
            StationName stationName = new StationName(name);
        } catch (Exception e) {
            actualResult = false;
        }

        //THEN
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void testCase2_isCorrectLineName() {
        //GIVEN
        String name = "역";

        //WHEN
        boolean actualResult = true;
        try {
            StationName stationName = new StationName(name);
        } catch (Exception e) {
            actualResult = false;
        }

        //THEN
        Assertions.assertFalse(actualResult);
    }
}

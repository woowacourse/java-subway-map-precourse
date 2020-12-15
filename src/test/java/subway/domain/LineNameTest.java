package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineNameTest {

    @Test
    public void testCase1_isCorrectLineName() {
        //GIVEN
        String name = "2호선";

        //WHEN
        boolean actualResult = true;
        try {
            LineName lineName = new LineName(name);
        } catch (Exception e) {
                actualResult = false;
        }

        //THEN
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void testCase2_isCorrectLineName() {
        //GIVEN
        String name = "2";

        //WHEN
        boolean actualResult = true;
        try {
            LineName lineName = new LineName(name);
        } catch (Exception e) {
            actualResult = false;
        }

        //THEN
        Assertions.assertFalse(actualResult);
    }
}

package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveNumberTest {

    @Test
    public void testCase1_isPositiveNumber() {
        //GIVEN
        String number = "-1";

        //WHEN
        boolean actualResult = true;
        try {
            PositiveNumber positiveNumber = new PositiveNumber(number);
        } catch (Exception e) {
            actualResult = false;
        }

        //THEN
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void testCase2_isCorrectLineName() {
        //GIVEN
        String number = "10";

        //WHEN
        boolean actualResult = true;
        try {
            PositiveNumber positiveNumber = new PositiveNumber(number);
        } catch (Exception e) {
            actualResult = false;
        }

        //THEN
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void testCase3_isCorrectLineName() {
        //GIVEN
        String number = "9";

        //WHEN
        boolean actualResult = true;
        try {
            PositiveNumber positiveNumber = new PositiveNumber(number);
        } catch (Exception e) {
            actualResult = false;
        }

        //THEN
        Assertions.assertTrue(actualResult);
    }
}

package subway.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
class InputTest {

    @Test
    @DisplayName("공백이 제거되는지")
    void blank() {
        String test = "잠   실      역";

        assertEquals("잠실역", test.replaceAll("\\p{Z}",""));
    }
}
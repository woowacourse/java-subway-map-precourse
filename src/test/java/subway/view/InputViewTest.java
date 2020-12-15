package subway.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void validateSubwayNamePattern() {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateSubwayNamePattern("종로  3가"));
        assertThrows(IllegalArgumentException.class, () -> InputView.validateSubwayNamePattern("종a3가"));
        assertThrows(IllegalArgumentException.class, () -> InputView.validateSubwayNamePattern("종^가"));
        assertThrows(IllegalArgumentException.class, () -> InputView.validateSubwayNamePattern("3333aa가"));
        assertThrows(IllegalArgumentException.class, () -> InputView.validateSubwayNamePattern(" 강남역"));
    }

    @Test
    void validateSubwayNamePatternTrue() {
        assertDoesNotThrow(() -> {
            InputView.validateSubwayNamePattern("강남역");
            InputView.validateSubwayNamePattern("양재역");
            InputView.validateSubwayNamePattern("양재시민역");
        });
    }
}
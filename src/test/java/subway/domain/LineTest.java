package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import subway.repository.LineRepository;

class LineTest {
    @Test
    public void 같은_라인_테스트() {
        Line line = new Line("2호선");
        LineRepository lineRepository = new LineRepository();

        Assertions.assertEquals(new Line("2호선"), line);
        Assertions.assertEquals(true, lineRepository.lines().contains(new Line("2호선")));
    }
}
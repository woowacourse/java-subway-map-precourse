package subway.domain.line;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineRepositoryTest {

    LineRepository lineRepository;

    @BeforeEach
    void before() {
        lineRepository = MemoryLineRepository.of();
    }

    @Test
    @DisplayName("노선 저장소 저장 확인")
    void testSave() {
        //given
        String line = "1호선";
        String line2 = "2호선";

        //when
        Line savedLine = lineRepository.addLine(Line.of(line));
        Line savedLine2 = lineRepository.addLine(Line.of(line2));
        Line findLine = lineRepository.findByName(line);
        Line findLine2 = lineRepository.findByName(line2);

        //then
        assertThat(savedLine.getName()).isEqualTo(findLine.getName());
        assertThat(savedLine2.getName()).isEqualTo(findLine2.getName());
    }
}
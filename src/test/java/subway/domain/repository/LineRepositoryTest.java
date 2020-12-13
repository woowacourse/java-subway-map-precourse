package subway.domain.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.entity.Line;
import subway.domain.entity.Sections;
import subway.domain.entity.Station;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class LineRepositoryTest {

    private final LineRepository lineRepository = new LineRepository(new ArrayList<>());
    private final Sections sections = Sections.of(new Station("이수역"), new Station("사당역"));
    private final Line line = new Line("1호선", sections);

    @BeforeEach
    void setUp() {
        lineRepository.save(line);
    }

    @DisplayName("Line 저장 성공")
    @Test
    void save_성공한다() {
        String name = lineRepository.findAll()
                .get(0)
                .getName();

        assertThat(name).isEqualTo("1호선");
    }
}

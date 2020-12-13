package subway.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.entity.Sections;
import subway.domain.entity.Station;
import subway.domain.repository.LineRepository;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatCode;

class LineServiceTest {

    private final LineRepository lineRepository = new LineRepository(new ArrayList<>());
    private final Sections sections = Sections.of(new Station("의정부역"), new Station("시청역"));
    private final LineService lineService = new LineService(lineRepository);

    @BeforeEach
    void setUp() {
        lineService.addLine("1호선", sections);
    }

    @DisplayName("Line 등록 실패 : 중복된 노선")
    @Test
    void addLine_중복된_노선_예외가_발생한다() {
        assertThatCode(() -> {
            lineService.addLine("1호선", sections);
        }).isInstanceOf(LineDuplicationException.class)
                .hasMessage("이미 등록된 노선 이름입니다.");
    }
}

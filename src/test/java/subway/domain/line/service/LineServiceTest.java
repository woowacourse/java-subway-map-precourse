package subway.domain.line.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.line.model.Line;
import subway.domain.line.model.LineRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineServiceTest {

    @AfterEach
    void tearDown() {
        LineRepository.deleteAll();
    }

    @DisplayName("지하철 노선의 목록을 조회하는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(
            value = {
                    "1호선,2호선,3호선:3", "신분당선,분당선,경의선,공항철도:4"
            }, delimiter = ':'
    )
    void testFindAll(String input, int lineNumber) {
        //given
        String[] lineNames = input.split(",");
        Arrays.stream(lineNames)
                .map(Line::new)
                .forEach(LineRepository::addLine);

        //when
        List<Line> lines = LineService.findAll();

        //then
        List<Line> expectedLines = Arrays.stream(lineNames)
                .map(Line::new)
                .collect(Collectors.toList());
        assertAll(
                () -> assertThat(lines)
                        .usingElementComparatorOnFields("name")
                        .containsAll(expectedLines),
                () -> assertThat(lines).hasSize(lineNumber)
        );
    }

    @DisplayName("지하철 노선을 등록하는 기능을 테스트한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "경의선", "신분당선", "1호선", "2호선"
    })
    void testSave(String lineName) {
        //when
        Line line = new Line(lineName);

        //when
        LineService.save(line);

        //then
        List<Line> lines = LineRepository.lines();
        assertAll(
                () -> assertThat(lines).hasSize(1),
                () -> assertThat(lines).usingElementComparatorOnFields("name")
                        .contains(line)
        );
    }

    @DisplayName("노선 이름이 중복되면 예외를 발생시키는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(value = {
            "1호선,2호선:1호선",
            "신분당선,경의선,분당선:경의선"
    }, delimiter = ':')
    void testSaveIfDuplicatedLineName(String input, String newLineName) {
        //given
        String[] lineNames = input.split(",");
        Arrays.stream(lineNames)
                .map(Line::new)
                .forEach(LineRepository::addLine);

        //when //then
        assertThatThrownBy(() -> LineService.save(new Line(newLineName)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}

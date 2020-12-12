package subway.domain.line.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import subway.domain.line.model.Line;
import subway.domain.line.model.LineRepository;
import subway.domain.station.model.Station;
import subway.domain.station.model.StationRepository;
import subway.domain.station.service.StationService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
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
}

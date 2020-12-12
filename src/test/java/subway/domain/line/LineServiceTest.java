package subway.domain.line;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.line.dto.LineSaveReqDto;
import subway.domain.station.Station;
import subway.domain.station.dto.StationSaveReqDto;
import subway.exception.ErrorCode;
import subway.exception.LineException;
import subway.exception.StationException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineServiceTest {

    LineService lineService;

    @BeforeEach
    void before() {
        lineService = new LineServiceImpl(MemoryLineRepository.of());
    }

    @Test
    @DisplayName("이미 등록된 노선일 시 에러가 발생한다. ")
    void testDuplicateSave() {
        //given
        String line = "1호선";
        String line2 = "1호선";

        //when
        lineService.saveLine(new LineSaveReqDto(line));

        //then
        assertThatThrownBy(() -> lineService.saveLine(new LineSaveReqDto(line2)))
                .isInstanceOf(LineException.class)
                .hasMessage(ErrorCode.LINE_ALREADY_EXIST.getMessage());
    }
}
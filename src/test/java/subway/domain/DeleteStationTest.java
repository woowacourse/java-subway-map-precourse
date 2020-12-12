package subway.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DeleteStationTest {

    private final Line line;

    private LineRepository lineRepository;

    public DeleteStationTest() {
        line = new Line("1호선", "강남역", "잠실역");
    }

    @BeforeEach
    public void initLineRepository() {
        lineRepository = new LineRepository().addLine(line);
    }

    @Test
    @DisplayName("존재하는 노선 삭제")
    public void deleteStation_ExistLine_EmptyLines() {

        // when
        LineRepository newLineRepository = lineRepository.removeLine("1호선");

        //then
        assertThat(newLineRepository.lines().isEmpty()).isTrue();
    }

    @Test
    @DisplayName("존재하지 않는 노선 삭제 시 예외 발생")
    public void deleteStation_DoesNotExistLine_ExceptionThrown() {

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> lineRepository.removeLine("신분당선");

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(LineRepository.DOES_NOT_EXIST_ERROR, "신분당선");
    }

    @Test
    @DisplayName("노선에 등록된 역 제거")
    public void deleteStation_oldStation_LineDeletedStation() {

        // given
        lineRepository = lineRepository.addRange(line.getName(), 1, "봉천역");

        // when
        lineRepository = lineRepository.removeRange("1호선", "봉천역");

        //then
        assertThat(lineRepository.lines().get(0).getStations().stations())
                .extracting(Station::getName).containsExactly("강남역", "잠실역");
    }

    @Test
    @DisplayName("노선의 역 개수가 최소 역 개수 이하일 경우 역 제거 시 예외 발생")
    public void deleteStation_LessThanMinimumStationSize_ExceptionThrown() {

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> lineRepository.removeRange("1호선", "강남역");

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.TOO_LESS_STATIONS_ERROR,
                        StationRepository.MINIMUM_STATION_SIZE);
    }

    @Test
    @DisplayName("상행 종점을 제거할 경우 그 다음 역이 종점")
    public void deleteStation_StartStation_StartsWithNextStation() {

        // given
        lineRepository = lineRepository.addRange(line.getName(), 1, "봉천역");

        // when
        lineRepository = lineRepository.removeRange("1호선", "강남역");

        //then
        assertThat(lineRepository.lines().get(0).getStations().stations())
                .extracting(Station::getName).containsExactly("봉천역", "잠실역");
    }

    @Test
    @DisplayName("하행 종점을 제거할 경우 그 다음 역이 종점")
    public void deleteStation_FinalStation_EndWithNextStation() {

        // given
        lineRepository = lineRepository.addRange(line.getName(), 1, "봉천역");

        // when
        lineRepository = lineRepository.removeRange("1호선", "잠실역");

        //then
        assertThat(lineRepository.lines().get(0).getStations().stations())
                .extracting(Station::getName).containsExactly("강남역", "봉천역");
    }
}

package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineRepositoryTest {

    @DisplayName("Line 등록 테스트")
    @Test
    public void testAddLine() {
        final String lineName = "1호선";
        LineRepository.addLine(lineName);
        assertThat(LineRepository.lines().get(0).getName()).isEqualTo(lineName);
    }

    @DisplayName("Line 등록 Stations 검증 테스트")
    @Test
    public void testValidateStations() {
        IllegalArgumentException throwEnoughStations = assertThrows(
            IllegalArgumentException.class, () -> testEnoughStations());
        assertThat(throwEnoughStations.getMessage()).isEqualTo("지하철 노선을 등록할 지하철 역 개수가 충분하지 않습니다.");

        IllegalArgumentException throwExistStation = assertThrows(
            IllegalArgumentException.class, () -> testExistStation());
        assertThat(throwExistStation.getMessage()).isEqualTo("해당 지하철 역은 등록되어 있지 않습니다.");

        IllegalArgumentException throwSameStation = assertThrows(
            IllegalArgumentException.class, () -> testSameStation());
        assertThat(throwSameStation.getMessage())
            .isEqualTo("상행 종점역과 하행 종점역은 서로 달라야 합니다.");
    }

    private void testEnoughStations() {
        StationRepository.addStation("뭔데역");
        LineRepository.enrollStartStation("뭔데역");
    }

    private void testExistStation() {
        StationRepository.addStation("그래역");
        StationRepository.addStation("싫어역");
        LineRepository.enrollStartStation("없는건데역");
    }

    private void testSameStation() {
        LineRepository.enrollStartStation("뭔데역");
        LineRepository.enrollEndStation("뭔데역");
    }

    @DisplayName("Line 등록 이름 검증 테스트")
    @Test
    public void testValidateName() {
        IllegalArgumentException throwNameContainWhitespace = assertThrows(
            IllegalArgumentException.class, () -> testNameContainWhitespace());
        assertThat(throwNameContainWhitespace.getMessage()).isEqualTo("지하철 노선 이름에 공백이 포함될 수 없습니다.");

        IllegalArgumentException throwNameEndWithRule = assertThrows(
            IllegalArgumentException.class, () -> testNameEndWithRule());
        assertThat(throwNameEndWithRule.getMessage()).isEqualTo("지하철 노선 이름은 \"선\"으로 끝나야 합니다.");

        IllegalArgumentException throwNameLength = assertThrows(
            IllegalArgumentException.class, () -> testNameLength());
        assertThat(throwNameLength.getMessage())
            .isEqualTo("지하철 노선 이름은 2글자 이상 + \"선\"으로 이루어져야 합니다.");

        IllegalArgumentException throwNameDuplicate = assertThrows(
            IllegalArgumentException.class, () -> testNameDuplicate());
        assertThat(throwNameDuplicate.getMessage()).isEqualTo("동일한 지하철 노선 이름이 존재합니다.");
    }

    private void testNameContainWhitespace() {
        final String lineName = " 선";
        LineRepository.addLine(lineName);
    }

    private void testNameEndWithRule() {
        final String lineName = "신분당";
        LineRepository.addLine(lineName);
    }

    private void testNameLength() {
        final String lineName = "신선";
        LineRepository.addLine(lineName);
    }

    private void testNameDuplicate() {
        final String lineName = "1호선";
        LineRepository.addLine(lineName);
    }

    @DisplayName("구간 등록 테스트")
    @Test
    public void testInsertLineStation() {
        LineRepository.insertLineSection("2호선", "호랑역", 2);
    }

}

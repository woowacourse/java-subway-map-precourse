package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StationRepositoryTest {

    @DisplayName("Station 생성자 테스트")
    @Test
    public void testAddStation() {
        final String testName1 = "뭔데";
        StationRepository.addStation(testName1);
        assertThat(StationRepository.stations().get(0).getName()).isEqualTo(testName1);

        final String testName2 = "오리";
        StationRepository.addStation(testName2);
        assertThat(StationRepository.stations().get(1).getName()).isEqualTo(testName2);

        final String testName3 = "테스트";
        StationRepository.addStation(testName3);
        assertThat(StationRepository.stations().get(2).getName()).isEqualTo(testName3);
    }

    @DisplayName("Station 생성자 이름길이 검증 테스트")
    @Test
    public void testValidateName() {
        IllegalArgumentException throwNameLength = assertThrows(
            IllegalArgumentException.class, () -> testNameLength());
        assertThat(throwNameLength.getMessage()).isEqualTo("지하철 역 이름은 2글자 이상이어야 합니다.");

        IllegalArgumentException throwNameDuplicate = assertThrows(
            IllegalArgumentException.class, () -> testNameDuplicate());
        assertThat(throwNameDuplicate.getMessage()).isEqualTo("동일한 지하철 역 이름이 존재합니다.");

        IllegalArgumentException throwNameContainWhitespace = assertThrows(
            IllegalArgumentException.class, () -> testNameContainWhitespace());
        assertThat(throwNameContainWhitespace.getMessage()).isEqualTo("지하철 역 이름에 공백이 포함될 수 없습니다.");
    }

    public void testNameLength() {
        final String testName = "";
        StationRepository.addStation(testName);
    }

    public void testNameDuplicate() {
        final String testName = "AAA";
        StationRepository.addStation(testName);
        StationRepository.addStation(testName);
    }

    public void testNameContainWhitespace() {
        final String testName = " ";
        StationRepository.addStation(testName);
    }

}

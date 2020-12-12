package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StationRepositoryTest {

    @DisplayName("Station 등록 중복 검증 테스트")
    @Test
    public void testAddStation() {
        final String testName1 = "뭔데역";
        Station newStation = Station.newStation(testName1);
        StationRepository.addStation(newStation);
        IllegalArgumentException throwNameDuplicate = assertThrows(
            IllegalArgumentException.class, () -> StationRepository.addStation(newStation));
        assertThat(throwNameDuplicate.getMessage()).isEqualTo("동일한 지하철 역 이름이 존재합니다.");
    }
}
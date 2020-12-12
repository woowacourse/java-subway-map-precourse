package subway.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StationServiceTest {
    private static final String TEST_STATION_NAME = "테스트역";

    public void setUp() {
        StationService.save(TEST_STATION_NAME);
    }

    @DisplayName("Station 저장 중복 검증 테스트")
    @Test
    public void testSaveValidate() {
        setUp();
        IllegalArgumentException throwNameDuplicate = assertThrows(
            IllegalArgumentException.class, () -> StationService.save(TEST_STATION_NAME));
        assertThat(throwNameDuplicate.getMessage()).isEqualTo("동일한 지하철 역 이름이 존재합니다.");
    }

    @DisplayName("Station 삭제 기능 테스트")
    @Test
    public void testDeleteStation() {
        StationService.delete("테스트역");
    }
}

package subway.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StationServiceTest {

    @DisplayName("Station 저장 중복 검증 테스트")
    @Test
    public void testSaveValidate() {
        StationService.save("테스트역");

        IllegalArgumentException throwNameDuplicate = assertThrows(
            IllegalArgumentException.class, () -> StationService.save("테스트역"));
        assertThat(throwNameDuplicate.getMessage()).isEqualTo("동일한 지하철 역 이름이 존재합니다.");
    }
}

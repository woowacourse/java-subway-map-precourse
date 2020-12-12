package subway.domain.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import subway.domain.type.exception.UnsupportedFunctionException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class ManagementTypeTest {

    private static Stream<Arguments> getManagementNumberAndManagementTypeSource() {
        return Stream.of(Arguments.of("1", ManagementType.STATION),
                Arguments.of("2", ManagementType.LINE),
                Arguments.of("3", ManagementType.SECTION),
                Arguments.of("4", ManagementType.SUBWAY_MAP_PRINT),
                Arguments.of("Q", ManagementType.EXIT));
    }

    @DisplayName("managementNumber에 해당하는 Enum 객체 반환")
    @ParameterizedTest
    @MethodSource("getManagementNumberAndManagementTypeSource")
    void findType_매칭되는_객체를_반환한다(String managementNumber, ManagementType managementType) {
        ManagementType targetType = ManagementType.findManagementType(managementNumber);

        assertThat(targetType).isEqualTo(managementType);
    }

    @DisplayName("managementNumber에 해당하는 Enum 객체가 없으면 예외 발생")
    @Test
    void findType_실패시_예외가_발생햔다() {
        assertThatCode(() -> {
            ManagementType.findManagementType("5");
        }).isInstanceOf(UnsupportedFunctionException.class)
                .hasMessage("선택할 수 없는 기능입니다.");
    }
}

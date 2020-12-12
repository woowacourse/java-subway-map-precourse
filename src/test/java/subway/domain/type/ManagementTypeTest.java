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
    void findManagementType_매칭되는_객체를_반환한다(String managementNumber, ManagementType managementType) {
        ManagementType targetType = ManagementType.findManagementType(managementNumber);

        assertThat(targetType).isEqualTo(managementType);
    }

    @DisplayName("managementNumber에 해당하는 Enum 객체가 없으면 예외 발생")
    @Test
    void findManagementType_실패시_예외가_발생햔다() {
        assertThatCode(() -> {
            ManagementType.findManagementType("5");
        }).isInstanceOf(UnsupportedFunctionException.class)
                .hasMessage("선택할 수 없는 기능입니다.");
    }

    @DisplayName("functionNumber로 ManagementType 객체가 보유하고 있는 FunctionType Enum 객체를 찾음")
    @Test
    void findFunctionType_매칭되는_객체를_반환한다() {
        ManagementType managementType = ManagementType.STATION;

        FunctionType functionType = managementType.findFunctionType("3");

        assertThat(functionType).isEqualTo(FunctionType.READ);
    }

    @DisplayName("SECTION ManagementType 객체는 READ(3) 기능이 없음")
    @Test
    void findFunctionType_예외가_발생한다() {
        ManagementType managementType = ManagementType.SECTION;

        assertThatCode(() -> {
            managementType.findFunctionType("3");
        }).isInstanceOf(UnsupportedFunctionException.class)
                .hasMessage("선택할 수 없는 기능입니다.");
    }
}

package subway.domain.type;

import subway.domain.type.exception.UnsupportedFunctionException;

import java.util.Arrays;

public enum ManagementType {
    STATION("1"),
    LINE("2"),
    SECTION("3"),
    SUBWAY_MAP_PRINT("4"),
    EXIT("Q");

    private final String managementNumber;

    private ManagementType(String managementNumber) {
        this.managementNumber = managementNumber;
    }

    public static ManagementType findManagementType(String managementNumber) {
        return Arrays.stream(ManagementType.values())
                .filter(managementType -> managementType.matches(managementNumber))
                .findFirst()
                .orElseThrow(UnsupportedFunctionException::new);
    }

    private boolean matches(String managementNumber) {
        return this.managementNumber.equals(managementNumber);
    }
}

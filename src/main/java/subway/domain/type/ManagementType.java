package subway.domain.type;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public enum ManagementType {
    STATION("1", "역",
            Arrays.asList(FunctionType.REGISTER, FunctionType.DELETE, FunctionType.READ, FunctionType.BACK)),
    LINE("2", "노선",
            Arrays.asList(FunctionType.REGISTER, FunctionType.DELETE, FunctionType.READ, FunctionType.BACK)),
    SECTION("3", "구간",
            Arrays.asList(FunctionType.REGISTER, FunctionType.DELETE, FunctionType.BACK)),
    SUBWAY_MAP_PRINT("4", "", Collections.emptyList()),
    EXIT("Q", "", Collections.emptyList());

    private final String managementNumber;
    private final String message;
    private final List<FunctionType> functionTypes;

    private ManagementType(String managementNumber, String message, List<FunctionType> functionTypes) {
        this.managementNumber = managementNumber;
        this.message = message;
        this.functionTypes = functionTypes;
    }

    public static ManagementType initiate() {
        return STATION;
    }

    public static ManagementType findManagementType(String managementNumber) {
        return Arrays.stream(ManagementType.values())
                .filter(managementType -> managementType.matches(managementNumber))
                .findFirst()
                .orElseThrow(UnsupportedFunctionException::new);
    }

    private boolean matches(String managementNumber) {
        return Objects.equals(this.managementNumber, managementNumber);
    }

    public FunctionType findFunctionType(String functionNumber) {
        return functionTypes.stream()
                .filter(functionType -> functionType.matches(functionNumber))
                .findFirst()
                .orElseThrow(UnsupportedFunctionException::new);
    }

    public boolean isRunning() {
        return this != EXIT;
    }

    @Override
    public String toString() {
        return message;
    }
}

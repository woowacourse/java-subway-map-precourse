package subway.domain.type;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum ManagementType {
    STATION("1",
            Arrays.asList(FunctionType.REGISTER, FunctionType.DELETE, FunctionType.READ, FunctionType.BACK)),
    LINE("2",
            Arrays.asList(FunctionType.REGISTER, FunctionType.DELETE, FunctionType.READ, FunctionType.BACK)),
    SECTION("3",
            Arrays.asList(FunctionType.REGISTER, FunctionType.DELETE, FunctionType.BACK)),
    SUBWAY_MAP_PRINT("4", Collections.emptyList()),
    EXIT("Q", Collections.emptyList());

    private final String managementNumber;
    private final List<FunctionType> functionTypes;

    private ManagementType(String managementNumber, List<FunctionType> functionTypes) {
        this.managementNumber = managementNumber;
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
        return this.managementNumber.equals(managementNumber);
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
}

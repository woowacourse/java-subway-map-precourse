package subway.constant;

import subway.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public enum Service {

    STATION("1"),
    LINE("2"),
    LINK("3"),
    MAP("4"),
    QUIT("Q");

    private static List<String> serviceCodes = new ArrayList<>();
    private String code;

    Service(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static void validate(String input) throws InvalidInputException {
        if (!isAvailable(input))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.INVALID_SERVICE_CODE);
    }

    private static boolean isAvailable(String input) {
        initServiceCodes();
        return serviceCodes.contains(input);
    }

    private static void initServiceCodes() {
        for (Service service : Service.values())
            serviceCodes.add(service.code);
    }
}

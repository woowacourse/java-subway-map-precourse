package subway.constant;

import java.util.ArrayList;
import java.util.List;

public enum Service {

    STATION("1"),
    LINE("2"),
    AREA("3"),
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

    public static boolean isAvailable(String input) {
        initServiceCodes();
        return serviceCodes.contains(input);
    }

    private static void initServiceCodes() {
        for (Service service : Service.values())
            serviceCodes.add(service.code);
    }
}

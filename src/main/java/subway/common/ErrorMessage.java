package subway.common;

public class ErrorMessage extends IllegalArgumentException {
    public static final String OUT = "OUT";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String STATION_ALREADY_ON_PATH = "입력하신 역은 구간에 이미 등록되어 있습니다.";
    private static final String NOT_NUMBER = "정수가 아닙니다. 순서는 1이상의 정수를 입력해 주세요.";
    private static final String NOT_OVER_ONE = "순서는 1이상의 정수로 가능합니다.";
    private static final String OVER_SIZE_PATH = "구간의 크기가 기존 사이즈를 넘어갑니다.";

    private static final String NOT_EXIST_STATION_ON_PATH = "노선에 등록되어 있지 않은 역입니다.";

    public ErrorMessage(String message) {
        super(ERROR_PREFIX+message);
    }


    public static void printStationAlreadyOnPath() {
        System.out.println(ERROR_PREFIX + STATION_ALREADY_ON_PATH);
    }

    public static void printNotNumber(){
        System.out.println(ERROR_PREFIX+NOT_NUMBER);
    }
    public static void printNotOverOne(){
        System.out.println(ERROR_PREFIX+NOT_OVER_ONE);
    }
    public static void printOverSizePath(){
        System.out.println(ERROR_PREFIX+OVER_SIZE_PATH);
    }

    public static void printNotEnrolledStationOnPath(){
        System.out.println(ERROR_PREFIX+NOT_EXIST_STATION_ON_PATH);
    }

}

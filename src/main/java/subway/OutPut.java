package subway;

public class OutPut {

    public static final String INFO = "[INFO] ";
    public static final String ERROR = "[ERROR] ";
    private static final String STATION_NAME_LENGTH_ERROR = "지하철 역의 이름은 2글자 이상이여야 합니다.\n";

    public static void printStationNameLengthError() {
        System.out.println(ERROR + STATION_NAME_LENGTH_ERROR);
    }

}

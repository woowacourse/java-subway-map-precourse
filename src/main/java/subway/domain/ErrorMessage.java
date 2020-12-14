package subway.domain;

public class ErrorMessage {

    static final String PREFIX = "[ERROR] ";
    static final String INVALID_FUNCTION_ERROR = "선택할 수 없는 기능입니다";
    static final String LESS_THAN_TWO_WORD_STATION_ERROR = "역 이름은 2자 이상으로 입력하세요";
    static final String NOT_CORRECT_STATION_NAME_ERROR = "마지막 글자는 '역' 으로 입력하세요";
    static final String ALREADY_EXIST_STATION_ERROR = "해당 역이 이미 등록되어 있습니다";
    static final String CANNOT_DELETE_STATION_ERROR = "해당 역은 삭제할 수 없습니다";
    static final String NOT_EXIST_STATION_ERROR = "해당 역은 존재하지 않습니다";
    static final String LESS_THAN_TWO_WORD_LINE_ERROR = "노선 이름은 2자 이상으로 입력하세요";
    static final String NOT_CORRECT_LINE_NAME_ERROR = "마지막 글자는 '선' 으로 입력하세요";
    static final String ALREADY_EXIST_LINE_ERROR = "해당 노선이 이미 등록되어 있습니다";
    static final String CANNOT_DELETE_LINE_ERROR = "해당 노선은 삭제할 수 없습니다";
    static final String NOT_EXIST_LINE_ERROR = "해당 노선은 존재하지 않습니다.";
    static final String NOT_INPUT_NUMBER_ERROR = "자연수를 입력하세요";
    static final String ALREADY_EXIST_STATION_IN_LINE_ERROR = "해당 역이 노선 안에 이미 존재합니다";
    static final String CANNOT_INPUT_INDEX_ERROR = "해당 번째로 구간 삽입 불가능합니다";

    public static void isInvalidFunction() {
        System.out.println(PREFIX + INVALID_FUNCTION_ERROR);
    }

    public static void isLessThanTwoWordStation() {
        System.out.println(PREFIX + LESS_THAN_TWO_WORD_STATION_ERROR);
    }

    public static void isNotCorrectStationName() {
        System.out.println(PREFIX + NOT_CORRECT_STATION_NAME_ERROR);
    }

    public static void isAlreadyExistStation() {
        System.out.println(PREFIX + ALREADY_EXIST_STATION_ERROR);
    }

    public static void isNotAbleToDeleteStation() {
        System.out.println(PREFIX + CANNOT_DELETE_STATION_ERROR);
    }

    public static void isNotExistStation() {
        System.out.println(PREFIX + NOT_EXIST_STATION_ERROR);
    }

    public static void isLessThanTwoWordLine() {
        System.out.println(PREFIX + LESS_THAN_TWO_WORD_LINE_ERROR);
    }

    public static void isNotCorrectLineName() {
        System.out.println(PREFIX + NOT_CORRECT_LINE_NAME_ERROR);
    }

    public static void isAlreadyExistLine() {
        System.out.println(PREFIX + ALREADY_EXIST_LINE_ERROR);
    }

    public static void isNotAbleToDeleteLine() {
        System.out.println(PREFIX + CANNOT_DELETE_LINE_ERROR);
    }

    public static void isNotExistLine() {
        System.out.println(PREFIX + NOT_EXIST_LINE_ERROR);
    }

    public static void isNotNumber() {
        System.out.println(PREFIX + NOT_INPUT_NUMBER_ERROR);
    }

    public static void isAlreadyExistStationInLine() {
        System.out.println(PREFIX + ALREADY_EXIST_STATION_IN_LINE_ERROR);
    }

    public static void isNotAbleToInsert() {
        System.out.println(PREFIX + CANNOT_INPUT_INDEX_ERROR);
    }


}


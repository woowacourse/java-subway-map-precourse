package subway.view;

public class ErrorView extends View {
    public static final String UNSELECTABLE = ERROR + "선택할 수 없는 기능입니다.";
    public static final String NO_EXIST_LINE = ERROR + "존재하지 않는 노선입니다.";
    public static final String NO_EXIST_SECTION = ERROR + "존재하지 않는 구간입니다.";
    public static final String NO_EXIST_STATION = ERROR + "존재하지 않는 역입니다.";
    public static final String ALREADY_EXIST_LINE = ERROR + "이미 존재하는 노선입니다.";
    public static final String ALREADY_EXIST_SECTION = ERROR + "이미 존재하는 구간입니다.";
    public static final String ALREADY_EXIST_STATION = ERROR + "이미 존재하는 역입니다.";
    public static final String MUST_BE_NUMBER = ERROR + " 순서로 입력된 값은 숫자여야 합니다.";
    public static final String AT_LEAST_TWO_LETTERS_LINE = ERROR + "노선 이름은 두글자 이상이어야 합니다.";
    public static final String AT_LEAST_TWO_LETTERS_STATION = ERROR + "역 이름은 두글자 이상이어야 합니다.";
    public static final String NAME_FORM_LINE = ERROR + "노선 이름은 자음 모음이 결합된 한글, 숫자, 영어로 이루어져 있고 '선' 이나 'LINE', 'Line', 'line' 으로 끝나야 합니다.\"";
    public static final String NAME_FORM_STATION = ERROR + "역 이름은 자음 모음이 결합된 한글, 숫자, 영어로 이루어져 있고 '역' 이나 'STATION', 'Station', 'station' 으로 끝나야 합니다.\"";
    public static final String UNABLE_TO_DELETE_ANYMORE = ERROR + "더 이상 해당 노선의 구간을 삭제할 수 없습니다.";
    public static final String UNABLE_TO_REGISTER_SECTION_BY_DIVERGENT_PATH = ERROR + "갈래길을 만듦으로 해당 구간을 생성할 수 없습니다.";

    public static void printError(String message) {
        newLine();
        System.out.println(message);
    }

    public static void printMustBeNumber() {
        newLine();
        System.out.println(MUST_BE_NUMBER);
    }

    public static String printExceedSequenceLimit(int limit) {
       return ERROR + "입력 가능한 순서값은 " + limit + " 미만입니다.";
    }


}

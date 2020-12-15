package subway.domain;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final int FUNCTION_INPUT_ERROR = 0;
    public static final int ALREADY_EXIST_ERROR = 1;
    public static final int NAME_LENGTH_ERROR = 2;
    public static final int NO_SUCH_NAME_ERROR = 3;
    public static final int HAS_IN_LINE_ERROR = 4;
    public static final int SAME_NAME_ERROR = 5;
    public static final int HAS_IN_SPECIFIC_LINE_ERROR = 6;
    public static final int UNVALID_INDEX_ERROR = 7;
    public static final int CANT_DELETE_SECTION_ERROR = 8;
    public static final int HAS_NOT_IN_SPECIFIC_LINE_ERROR = 9;

    public static final List<String> MAIN_FUNCTIONS = Arrays.asList("1", "2", "3", "4", "Q");
    public static final String STATION_MENU = "1";
    public static final String LINE_MENU = "2";
    public static final String SECTION_MENU = "3";
    public static final String PRINT_LINES = "4";
    public static final String FINISH_PROGRAM = "Q";
    public static final List<String> SUB_FUNCTIONS = Arrays.asList("1", "2", "3", "B");
    public static final String ADD_MENU = "1";
    public static final String DELETE_MENU = "2";
    public static final String SEARCH_MENU = "3";
    public static final String GO_BACK_MENU = "B";
    public static final List<String> SECTION_FUNCTIONS = Arrays.asList("1", "2", "B");
}

package subway.view;

public class OutputView {
    private static final String INFO = "[INFO] ";
    private static final String INFO_LINE = "---";
    private static final String ERROR = "[ERROR] ";
    private static final String REGISTER_STATION_COMPLETE = "지하철 역이 등록되었습니다.";
    private static final String DELETE_STATION_COMPLETE = "지하철 역이 삭제되었습니다.";
    private static final String REGISTER_LINE_COMPLETE = "지하철 노선이 등록되었습니다.";
    private static final String DELETE_LINE_COMPLETE = "지하철 노선이 삭제되었습니다.";
    private static final String REGISTER_SECTION_COMPLETE = "구간이 등록되었습니다.";
    private static final String DELETE_SECTION_COMPLETE = "구간이 삭제되었습니다.";

    private static final String CANNOT_SELECT_MENU_ERROR = "선택할 수 없는 기능입니다.";
    private static final String ALREADY_EXIST_STATION_ERROR = "이미 등록된 역 이름입니다.";
    private static final String ALREADY_EXIST_LINE_ERROR = "이미 등록된 노선입니다.";
    private static final String NAME_LENGTH_ERROR = "이름은 2글자 이상이어야 합니다.";
    private static final String CANNOT_DELETE_ERROR = "삭제할 수 없습니다.";

    public static void registerStationComplete() {
        System.out.println(INFO + REGISTER_STATION_COMPLETE + "\n");
    }

    public static void deleteStationComplete() {
        System.out.println(INFO + DELETE_STATION_COMPLETE + "\n");
    }

    public static void registerLineComplete() {
        System.out.println(INFO + REGISTER_LINE_COMPLETE + "\n");
    }

    public static void deleteLineComplete() {
        System.out.println(INFO + DELETE_LINE_COMPLETE + "\n");
    }

    public static void registerSectionComplete() {
        System.out.println(INFO + REGISTER_SECTION_COMPLETE + "\n");
    }

    public static void deleteSectionComplete() {
        System.out.println(INFO + DELETE_SECTION_COMPLETE + "\n");
    }

    public static void cannotSelectMenuError() {
        System.out.println(ERROR + CANNOT_SELECT_MENU_ERROR + "\n");
    }

    public static void alreadyExistStationError() {
        System.out.println(ERROR + ALREADY_EXIST_STATION_ERROR + "\n");
    }

    public static void alreadyExistLineError() {
        System.out.println(ERROR + ALREADY_EXIST_LINE_ERROR + "\n");
    }

    public static void isNotValidNameLength() {
        System.out.println(ERROR + NAME_LENGTH_ERROR + "\n");
    }

    public static void CannotDeleteError() {
        System.out.println(ERROR + CANNOT_DELETE_ERROR + "\n");
    }
}

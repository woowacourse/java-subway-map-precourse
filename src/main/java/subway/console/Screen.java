package subway.console;

public class Screen extends ConsoleValidator implements SectionScreen, StationScreen, LineScreen, MainScreen {
    public static String MESSAGE_MENU_SELECT = "## 원하는 기능을 선택하세요.";
    public static String ERROR_MAIN_SCREEN_NOT_VALID_INPUT = "[ERROR] 잘못된 기능 입력입니다.";
    // todo: 화면에서 보이는 것들 관리하기
}
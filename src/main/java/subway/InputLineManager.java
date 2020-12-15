package subway;

import subway.domain.Line;
import subway.domain.LineName;
import subway.domain.LineRepository;

import java.util.Arrays;
import java.util.Scanner;

public class InputLineManager implements InputManager {
    private static final String LINE_MAIN_MENU = "## 노선 관리 화면\n1. 노선 등록\n" +
                                                    "2. 노선 삭제\n3. 노선 조회\nB. 돌아가기\n";
    private static final String WRONG_STATE_TRY_AGAIN = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String INPUT_LINE_TO_ENROLL = "## 등록할 노선 이름을 입력하세요.";
    private static final String DUPLICATED_TRY_AGAIN = "[ERROR] 중복됩니다.";
    private static final String INPUT_START_STATION_TO_ENROLL = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String LINE_MENU = "2";

    private Scanner scanner;

    private enum Menu {
        REGISTER("1", ((InputLineManager) SubwayManager.getMenus(LINE_MENU))::register);
//        DELETE("2"),
//        INQUIRY("3"),
//        BACK("B");

        private final String name;
        private final Runnable runnable;

        Menu(String name, Runnable runnable) {
            this.name = name;
            this.runnable = runnable;
        }
        public static void execute(String input) {
            Arrays.stream(values())
                    .filter(value -> value.name.equals(input))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(WRONG_STATE_TRY_AGAIN))
                    .runnable.run();
        }
    }

    public InputLineManager(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void selectMenu() {
        try {
            System.out.println(LINE_MAIN_MENU);
            String state = scanner.next();
            Menu.execute(state);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            selectMenu();
        }
    }

    @Override
    public void register() {
        try {
            System.out.println(INPUT_LINE_TO_ENROLL);
            Line line = new Line(new LineName(scanner.next()));
            if (LineRepository.lines().contains(line)) {
                throw new IllegalArgumentException(DUPLICATED_TRY_AGAIN);
            }
            System.out.println(INPUT_START_STATION_TO_ENROLL);
            LineRepository.addLine(line);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            register();
        }
    }

    @Override
    public void delete() {

    }

}

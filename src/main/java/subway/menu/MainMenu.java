package subway.menu;

import subway.domain.Line.Line;
import subway.domain.Line.LineRepository;
import subway.exception.MenuNotFountException;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;

public enum MainMenu implements Menu {

    STATION("1", "역 관리") {
        @Override
        public Menu run() {
            return StationMenu.BACK;
        }
    },
    LINE("2", "노선 관리") {
        @Override
        public Menu run() {
            return LineMenu.BACK;
        }
    },
    SECTION("3", "구간 관리") {
        @Override
        public Menu run() {
            return SectionMenu.BACK;
        }
    },
    MAP("4", "지하철 노선도 출력") {
        @Override
        public Menu run() {
            LineRepository lineRepository = new LineRepository();
            List<Line> lines = lineRepository.lines();

            OutputView.printMap(lines);

            return MainMenu.LINE;
        }
    },
    QUIT("Q", "종료");

    final String order;
    final String menu;

    private static final String MENU_TITLE = "메인 ";
    private static final String MENU_TYPE = "메인";

    MainMenu(String order, String menu) {
        this.order = order;
        this.menu = menu;
    }

    @Override
    public String toString() {
        return order + ". " + menu;
    }


    @Override
    public Menu run() {
        return null;
    }

    @Override
    public Menu[] getValues() {
        return values();
    }

    @Override
    public String getTitle() {
        return MENU_TITLE;
    }

    @Override
    public Menu change(String command) {
        return Arrays
                .stream(values())
                .filter(menu -> menu.order.equals(command))
                .findFirst().orElseThrow(() ->
                        new MenuNotFountException(command)
                );
    }

    @Override
    public String getName() {
        return MENU_TYPE;
    }

    @Override
    public String getActionType() {
        return getName();
    }


}

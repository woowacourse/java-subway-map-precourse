package subway.menu;

import subway.domain.Line.Line;
import subway.domain.Line.LineRepository;
import subway.view.OutputView;

import java.util.List;

public enum MainMenu implements Menu {

    STATION("1", "역 관리", Action.BACK) {
        @Override
        public Menu run() {
            return StationMenu.BACK;
        }
    },
    LINE("2", "노선 관리", Action.BACK) {
        @Override
        public Menu run() {
            return LineMenu.BACK;
        }
    },
    SECTION("3", "구간 관리", Action.BACK) {
        @Override
        public Menu run() {
            return SectionMenu.BACK;
        }
    },
    MAP("4", "지하철 노선도 출력", Action.BACK) {
        @Override
        public Menu run() {
            LineRepository lineRepository = new LineRepository();
            List<Line> lines = lineRepository.lines();

            OutputView.printMap(lines);

            return MainMenu.LINE;
        }
    },
    QUIT("Q", "종료", Action.BACK);

    final String order;
    final String menu;
    final Action action;

    private static final String MENU_TITLE = "메인 ";
    private static final String MENU_TYPE = "메인";

    MainMenu(String order, String menu, Action action) {
        this.order = order;
        this.menu = menu;
        this.action = action;
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
    public String getType() {
        return MENU_TYPE;
    }

    @Override
    public Action getAction() {
        return action;
    }

    @Override
    public String getOrder() {
        return order;
    }
}

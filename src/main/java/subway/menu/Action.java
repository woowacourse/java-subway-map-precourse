package subway.menu;

import subway.controller.ControllerFactory;
import subway.controller.SubwayController;
import subway.view.OutputView;

public enum Action {

    REGISTER("등록") {
        @Override
        public Menu action(Menu menu) {
            try {
                SubwayController controller = ControllerFactory.getInstance(menu);
                controller.save();
                return MainMenu.SECTION;
            } catch (Exception e) {
                OutputView.printErrorMessage(e);
                return menu;
            }
        }
    },
    DELETE("삭제") {
        @Override
        public Menu action(Menu menu) {
            try {
                SubwayController controller = ControllerFactory.getInstance(menu);
                controller.delete();
                return MainMenu.SECTION;
            } catch (Exception e) {
                OutputView.printErrorMessage(e);
                return menu;
            }
        }
    },
    SEARCH("조회") {
        @Override
        public Menu action(Menu menu) {
            try {
                SubwayController controller = ControllerFactory.getInstance(menu);
                controller.findAll();
                return MainMenu.SECTION;
            } catch (Exception e) {
                return menu;
            }
        }
    },
    BACK("") {
        @Override
        public Menu action(Menu menu) {
            return MainMenu.SECTION;
        }
    };

    final String action;

    Action(String action) {
        this.action = action;
    }

    abstract public Menu action(Menu menu);

    @Override
    public String toString() {
        return action;
    }
}

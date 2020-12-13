package subway.menu;

import subway.controller.ControllerFactory;
import subway.controller.SubwayController;

public enum Action {

    REGISTER("등록") {
        @Override
        public Menu action(Menu menu) {
            SubwayController controller = ControllerFactory.of(menu);
            controller.save();
            return MainMenu.SECTION;
        }
    },
    DELETE("삭제") {
        @Override
        public Menu action(Menu menu) {
            SubwayController controller = ControllerFactory.of(menu);
            controller.delete();
            return MainMenu.SECTION;

        }
    },
    SEARCH("조회") {
        @Override
        public Menu action(Menu menu) {
            SubwayController controller = ControllerFactory.of(menu);
            controller.findAll();
            return MainMenu.SECTION;

        }
    },
    BACK("") {
        @Override
        public Menu action(Menu menu) {
            //아무것도 안함
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

package subway.menu;

import subway.controller.ControllerFactory;
import subway.controller.SubwayController;

public enum Action {

    REGISTER("등록") {
        @Override
        public void action(Menu menu) {
            SubwayController controller = ControllerFactory.of(menu);
            controller.save();
        }
    },
    DELETE("삭제") {
        @Override
        public void action(Menu menu) {
            SubwayController controller = ControllerFactory.of(menu);
            controller.delete();
        }
    },
    SEARCH("조회") {
        @Override
        public void action(Menu menu) {
            SubwayController controller = ControllerFactory.of(menu);
            controller.findAll();
        }
    },
    BACK("") {
        @Override
        public void action(Menu menu) {
            //아무것도 안함
        }
    };

    final String action;

    Action(String action) {
        this.action = action;
    }

    abstract public void action(Menu menu);

    @Override
    public String toString() {
        return action;
    }
}

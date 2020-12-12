package subway;

import subway.controller.SubwayController;

public enum Action {

    REGISTER() {
        @Override
        public void action(SubwayController controller) {
            controller.save();
        }
    },
    DELETE() {
        @Override
        public void action(SubwayController controller) {
            controller.delete();
        }
    },
    SEARCH() {
        @Override
        public void action(SubwayController controller) {
            controller.findAll();
        }
    },
    BACK() {
        @Override
        public void action(SubwayController controller) {
            // 아무것도 안함
        }
    };


    Action() {
    }

    abstract public void action(SubwayController controller);

}

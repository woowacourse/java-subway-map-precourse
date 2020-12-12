package subway;

import subway.controller.SubwayController;

public enum Action {

    REGISTER() {
        @Override
        void action(SubwayController controller) {
            controller.save();
        }
    },
    DELETE() {
        @Override
        void action(SubwayController controller) {
            controller.delete();
        }
    },
    SEARCH() {
        @Override
        void action(SubwayController controller) {
            controller.findAll();
        }
    },
    BACK() {
        @Override
        void action(SubwayController controller) {
            // 아무것도 안함
        }
    };


    Action() {
    }

    abstract void action(SubwayController controller);

}

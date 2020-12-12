package subway;

import subway.controller.SubwayController;

public enum Action {

    REGISTER("등록") {
        @Override
        public void action(SubwayController controller) {
            controller.save();
        }
    },
    DELETE("삭제") {
        @Override
        public void action(SubwayController controller) {
            controller.delete();
        }
    },
    SEARCH("조회") {
        @Override
        public void action(SubwayController controller) {
            controller.findAll();
        }
    },
    BACK("") {
        @Override
        public void action(SubwayController controller) {
            // 아무것도 안함
        }
    };

    final String action;

    Action(String action) {
        this.action = action;
    }

    abstract public void action(SubwayController controller);

    @Override
    public String toString() {
        return action;
    }
}

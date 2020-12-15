package subway.type;

import subway.view.LineOutputView;
import subway.view.SectionOutputView;
import subway.view.StationInputView;

public enum StationScreenFunctionType {
    REGISTER_STATION(1) {
        @Override
        public void execute() {
            System.out.println(("1"));
        }
    },
    REMOVE_STATION(2) {
        @Override
        public void execute() {
            System.out.println("2");
        }
    },
    PRINT_STATION(3) {
        @Override
        public void execute() {
            System.out.println("3");
        }
    };

    private final int functionCode;

    StationScreenFunctionType(int functionCode) {
        this.functionCode = functionCode;
    }

    public boolean isSameFunctionCode(int number) {
        return this.functionCode == number;
    }

    public abstract void execute();
}

package subway.type;

import subway.view.LineInputView;

public enum LineScreenFunctionType {
    REGISTER_STATION(1) {
        @Override
        public void execute() {
            LineInputView.registerLine();
        }
    },
    REMOVE_STATION(2) {
        @Override
        public void execute() {
            LineInputView.removeLine();
        }
    },
    PRINT_STATION(3) {
        @Override
        public void execute() {
            System.out.println("3");
        }
    };

    private final int functionCode;

    LineScreenFunctionType(int functionCode) {
        this.functionCode = functionCode;
    }

    public boolean isSameFunctionCode(int number) {
        return this.functionCode == number;
    }

    public abstract void execute();
}

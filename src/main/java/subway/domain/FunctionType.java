package subway.domain;

import subway.view.OutputView;

import java.util.Arrays;

public enum FunctionType {
    MANAGE_STATION(1) {
        @Override
        public void execute() {
            OutputView.printManageStationScreen();
        }
    },
    MANAGE_LINE(2) {
        @Override
        public void execute() {
            System.out.println("2 고름");
        }
    },
    MANAGE_SECTION(3) {
        @Override
        public void execute() {
            System.out.println("3 고름");
        }
    },
    PRINT_MAP(4) {
        @Override
        public void execute() {
            System.out.println("4 고름");
        }
    };

    private final int functionCode;

    FunctionType(int functionCode) {
        this.functionCode = functionCode;
    }

    public boolean isSameFunctionCode(int number) {
        return this.functionCode == number;
    }

    public abstract void execute();
}

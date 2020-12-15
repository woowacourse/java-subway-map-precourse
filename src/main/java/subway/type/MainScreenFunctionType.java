package subway.domain;

import subway.view.LineOutputView;
import subway.view.SectionOutputView;
import subway.view.StationOutputView;

public enum FunctionType {
    MANAGE_STATION(1) {
        @Override
        public void execute() {
            StationOutputView.printManageStationScreen();
        }
    },
    MANAGE_LINE(2) {
        @Override
        public void execute() {
            LineOutputView.printManageLineScreen();
        }
    },
    MANAGE_SECTION(3) {
        @Override
        public void execute() {
            SectionOutputView.printManageSectionScreen();
        }
    },
    PRINT_MAP(4) {
        @Override // TODO 지하철 노선도 출력
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

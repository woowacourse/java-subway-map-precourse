package subway.type;

import subway.domain.LineRepository;
import subway.view.LineInputView;
import subway.view.SectionOutputView;
import subway.view.StationInputView;

public enum MainScreenFunctionType {
    MANAGE_STATION(1) {
        @Override
        public void execute() {
            StationInputView.getStationScreenUserSelection();
        }
    },
    MANAGE_LINE(2) {
        @Override
        public void execute() {
            LineInputView.getLineScreenUserSelection();
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
            LineRepository.printMap();
        }
    };

    private final int functionCode;

    MainScreenFunctionType(int functionCode) {
        this.functionCode = functionCode;
    }

    public boolean isSameFunctionCode(int number) {
        return this.functionCode == number;
    }

    public abstract void execute();
}

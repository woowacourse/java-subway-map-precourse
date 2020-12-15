package subway.type;

import subway.view.StationInputView;

import static subway.domain.StationRepository.printStations;

public enum StationScreenFunctionType {
    REGISTER_STATION(1) {
        @Override
        public void execute() {
            StationInputView.registerStation();
        }
    },
    REMOVE_STATION(2) {
        @Override
        public void execute() {
            StationInputView.removeStation();
        }
    },
    PRINT_STATION(3) {
        @Override
        public void execute() {
            printStations();
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

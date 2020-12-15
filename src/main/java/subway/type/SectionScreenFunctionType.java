package subway.type;

import subway.view.LineInputView;
import subway.view.SectionInputView;

public enum SectionScreenFunctionType {
    REGISTER_SECTION(1) {
        @Override
        public void execute() {
            SectionInputView.registerSection();
        }
    },
    REMOVE_SECTION(2) {
        @Override
        public void execute() {
            SectionInputView.removeSection();
        }
    };

    private final int functionCode;

    SectionScreenFunctionType(int functionCode) {
        this.functionCode = functionCode;
    }

    public boolean isSameFunctionCode(int number) {
        return this.functionCode == number;
    }

    public abstract void execute();
}

package subway.service.section;

import subway.service.abstraction.input.InputInterface;
import subway.type.InputType;

public class SectionInputService implements InputInterface {
    @Override
    public boolean isInput(String input) {
        if (input.equals(InputType.INPUT_ONE.getInput())) {
            return true;
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            return true;
        }
        return input.equals(InputType.INPUT_BACK.getInput());
    }
}

package subway.service;

import subway.service.abstraction.input.InputInterface;
import subway.type.InputType;
import subway.view.output.ExceptionView;

public class InputService implements InputInterface {
    @Override
    public boolean isInput(String input) {
        if (input.equals(InputType.INPUT_ONE.getInput())) {
            return true;
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            return true;
        }
        if (input.equals(InputType.INPUT_THREE.getInput())) {
            return true;
        }
        if (input.equals(InputType.INPUT_BACK.getInput())) {
            return true;
        }
        ExceptionView.printInvalidFeatureChoiceException();
        return false;
    }
}

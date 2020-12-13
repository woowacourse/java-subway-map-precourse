package subway.domain;

import java.util.Arrays;
import java.util.function.Function;

import subway.view.InputView;
import subway.view.OutputView;

public interface Functionable {

    Function<ManageController, ManageController> getFunction();

    boolean equalsIdentifier(String identifier);

    static ManageController function(ManageController manageController,
                                     Functionable[] functionables) {
        OutputView.printView(functionables);

        String identifier = InputView.inputFunctionIdentifier();

        return Arrays.stream(functionables)
                .filter(functionable -> functionable.equalsIdentifier(identifier))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."))
                .getFunction()
                .apply(manageController);
    }
}

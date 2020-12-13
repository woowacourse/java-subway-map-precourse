package subway.domain.function;

import java.util.Arrays;
import java.util.function.Function;

import subway.controller.ManageController;
import subway.view.InputView;
import subway.view.OutputView;

public interface Functionable {

    String getIdentifier();

    String getDescription();

    Function<ManageController, ManageController> getFunction();

    boolean equalsIdentifier(String identifier);

    static ManageController function(ManageController manageController, String viewTitle,
                                     Functionable[] functionables) {
        OutputView.printFunctions(viewTitle, functionables);

        String identifier = InputView.inputFunctionIdentifier();

        return Arrays.stream(functionables)
                .filter(functionable -> functionable.equalsIdentifier(identifier))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."))
                .getFunction()
                .apply(manageController);
    }
}

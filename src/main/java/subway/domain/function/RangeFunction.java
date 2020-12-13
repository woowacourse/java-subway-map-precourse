package subway.domain.function;

import java.util.function.Function;

import subway.controller.ManageController;
import subway.view.InputView;

public enum RangeFunction implements Functionable {
    ADD("1", "구간 등록",
            manageController -> manageController
                    .addRange(InputView.inputLineName(), InputView.inputStation(),
                            InputView.inputIndex())),

    REMOVE("2", "구간 삭제",
            manageController -> manageController
                    .removeRange(InputView.inputLineName(), InputView.inputStation())),

    BACK("B", "돌아가기", Function.identity());

    public static final String TITLE = "구간 관리";

    private final String identifier;

    private final String description;

    private final Function<ManageController, ManageController> function;

    RangeFunction(String identifier, String description,
                  Function<ManageController, ManageController> function) {
        this.identifier = identifier;
        this.description = description;
        this.function = function;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Function<ManageController, ManageController> getFunction() {
        return function;
    }

    @Override
    public boolean equalsIdentifier(String identifier) {
        return this.identifier.equals(identifier);
    }
}

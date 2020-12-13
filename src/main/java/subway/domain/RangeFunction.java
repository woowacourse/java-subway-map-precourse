package subway.domain;

import java.util.function.Function;

public enum RangeFunction implements Functionable {
    ADD("1", "구간 등록", ManageController::addRange),
    REMOVE("2", "구간 삭제", ManageController::removeRange),
    BACK("B", "돌아가기", Function.identity());

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
    public Function<ManageController, ManageController> getFunction() {
        return function;
    }

    @Override
    public boolean equalsIdentifier(String identifier) {
        return this.identifier.equals(identifier);
    }
}

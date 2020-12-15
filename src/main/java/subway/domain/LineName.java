package subway.domain;

import java.util.Objects;

import subway.validator.LineNameValidator;
import subway.validator.ValidatorPool;

public final class LineName {

    public static final int LENGTH_LOWER_BOUND = 2;

    public static final int LENGTH_UPPER_BOUND = 10;

    private final String name;

    public LineName(final String name) {
        ValidatorPool.getValidator(LineNameValidator.class).validate(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object checkObject) {
        if (this == checkObject) {
            return true;
        }

        if (!(checkObject instanceof LineName)) {
            return false;
        }

        LineName lineName = (LineName) checkObject;

        return Objects.equals(getName(), lineName.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

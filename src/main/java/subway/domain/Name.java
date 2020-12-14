package subway.domain;

import subway.domain.validator.NameValidator;

public class Name {
    private static final int MINIMUM_NAME_LENGTH = 2;
    private String name;

    public Name(String name) {
        NameValidator.checkIsValidLength(name, MINIMUM_NAME_LENGTH);
        this.name = name.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Name) {
            return ((Name) o).name.equals(this.name);
        }

        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}

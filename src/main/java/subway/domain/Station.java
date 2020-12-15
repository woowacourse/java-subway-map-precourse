package subway.domain;

import subway.utils.ValidationUtils;

public class Station {
    private static final DomainNamingForm namingForm = DomainNamingForm.STATION;

    private String name;

    public Station(String name) {
        ValidationUtils.validateTooShortName(name, namingForm);
        ValidationUtils.validateInvalidSuffix(name, namingForm);

        this.name = name;
    }

    public String getName() {
        return name;
    }
}

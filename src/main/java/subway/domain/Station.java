package subway.domain;

import subway.utils.ValidationUtils;

public class Station {
    private String name;

    public Station(String name) {
        ValidationUtils.validateTooShortName(name, DomainNamingForm.STATION);
        ValidationUtils.validateInvalidSuffix(name, DomainNamingForm.STATION);

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
